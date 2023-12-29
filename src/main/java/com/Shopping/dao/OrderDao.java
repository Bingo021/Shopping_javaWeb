package com.Shopping.dao;

import com.Shopping.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    void addOrder(Order order);

    Order getOrderById(int orderID) throws SQLException;

    List<Order> getUserOrders(int userID) throws SQLException;

    void updateOrderStatus(int orderID, String orderStatus);
}
