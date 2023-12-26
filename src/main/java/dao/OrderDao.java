package dao;

import model.Order;

import java.util.List;

public interface OrderDao {
    void addOrder(Order order);
    Order getOrderById(int orderID);
    List<Order> getUserOrders(int userID);
    void updateOrderStatus(int orderID, String orderStatus);
}
