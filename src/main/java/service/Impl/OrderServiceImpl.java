package service.Impl;

import dao.OrderDao;
import model.Order;
import service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        return orderDao.getOrderById(orderId);
    }

    @Override
    public List<Order> getUserOrders(int userId) throws SQLException {
        return orderDao.getUserOrders(userId);
    }

    @Override
    public void updateOrderStatus(int orderId, String orderStatus) {
        orderDao.updateOrderStatus(orderId, orderStatus);
    }
}

