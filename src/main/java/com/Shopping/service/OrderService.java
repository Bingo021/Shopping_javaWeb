package com.Shopping.service;

import com.Shopping.model.DeliveryAddress;
import com.Shopping.model.Order;

import java.util.List;

public interface OrderService {
    // 用户从购物车下单
    Order placeOrderFromCart(int userId, DeliveryAddress deliveryAddress, String paymentMethod);

    // 用户从商品页面直接下单
    Order placeOrderFromProductPage(int userId, int productId, int quantity, DeliveryAddress deliveryAddress, String paymentMethod);

    Order getOrderById(int orderId);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getAllOrders(); // 获取所有订单（管理员视角）

    void updateOrderStatusByAdmin(int orderId, String newStatus);
}

