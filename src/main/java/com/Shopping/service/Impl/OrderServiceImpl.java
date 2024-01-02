package com.Shopping.service.Impl;

import com.Shopping.model.DeliveryAddress;
import com.Shopping.model.Order;
import com.Shopping.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order placeOrderFromCart(int userId, DeliveryAddress deliveryAddress, String paymentMethod) {
        return null;
    }

    @Override
    public Order placeOrderFromProductPage(int userId, int productId, int quantity, DeliveryAddress deliveryAddress, String paymentMethod) {
        return null;
    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void updateOrderStatusByAdmin(int orderId, String newStatus) {

    }
}

