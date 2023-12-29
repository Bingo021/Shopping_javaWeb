package service;

import model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    Order getOrderById(int orderId) throws SQLException;

    List<Order> getUserOrders(int userId) throws SQLException;

    void updateOrderStatus(int orderId, String orderStatus);
}

