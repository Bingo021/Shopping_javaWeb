package com.Shopping.service;

import com.Shopping.model.Order;

import java.util.List;

public interface OrderService {
    // 从购物车下单
    Order placeOrderFromCart(int userId, int cartId);

    // 从商品页面直接下单
    Order placeOrderFromProductPage(int userId, int productId, int quantity);

    // 获取订单详情
    Order getOrderById(int orderId);

    // 获取用户所有订单
    List<Order> getOrdersByUserId(int userId);

    // 获取所有订单
    List<Order> getAllOrders();

    // 管理员更新订单状态
    void updateOrderStatusByAdmin(int orderId, String newStatus);

    // 取消订单
    void cancelOrder(int orderId);

    // 确认收货
    void confirmReceipt(int orderId);
}

