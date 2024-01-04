package com.Shopping.service.Impl;

import com.Shopping.dao.Impl.OrderDaoImpl;
import com.Shopping.dao.Impl.OrderDetailDaoImpl;
import com.Shopping.dao.OrderDao;
import com.Shopping.dao.OrderDetailDao;
import com.Shopping.model.Cart;
import com.Shopping.model.Order;
import com.Shopping.model.OrderDetail;
import com.Shopping.model.Product;
import com.Shopping.service.CartService;
import com.Shopping.service.OrderService;
import com.Shopping.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final CartService cartService = new CartServiceImpl();

    public OrderServiceImpl() {

    }


    @Override
    public Order placeOrderFromCart(int userId, int cartId) {
        Cart cart = cartService.getCart(userId);
        Order order = new Order(userId, cart.getProductID());
        orderDao.addOrder(order);

        // 选购物车中的商品，创建订单详情对象，并关联到订单
        Product product = productService.getProductById(cart.getProductID());
        OrderDetail orderDetail = new OrderDetail(order.getOrderID(), product.getProductID(), cart.getQuantity(), product.getPrice());
        orderDetailDao.addOrderDetail(orderDetail);

        cartService.removeFromCart(userId, cart.getProductID());

        return order;
    }

    @Override
    public Order placeOrderFromProductPage(int userId, int productId, int quantity) {
        // 实现从商品页面直接下单的逻辑
        Product product = productService.getProductById(productId);

        Order order = new Order(userId, product.getProductID());
        orderDao.addOrder(order);

        OrderDetail orderDetail = new OrderDetail(order.getOrderID(), product.getProductID(), quantity, product.getPrice());
        orderDetailDao.addOrderDetail(orderDetail);

        return order;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try {
            order = orderDao.getOrderById(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = null;
        try {
            orders = orderDao.getUserOrders(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public void updateOrderStatusByAdmin(int orderId, String newStatus) {
        orderDao.updateOrderStatus(orderId, newStatus);
    }

    @Override
    public void cancelOrder(int orderId) {
        // 实现取消订单的逻辑
        Order order = null;
        try {
            order = orderDao.getOrderById(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        orderDao.updateOrderStatus(orderId, "订单取消");
    }

    @Override
    public void confirmReceipt(int orderId) {
        // 实现确认收货的逻辑
        Order order = null;
        try {
            order = orderDao.getOrderById(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        orderDao.updateOrderStatus(orderId, "已签收");
    }
}

