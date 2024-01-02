package com.Shopping.dao.Impl;

import com.Shopping.dao.OrderDao;
import com.Shopping.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public OrderDaoImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder(Order order) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO orders (UserID, ProductID, OrderStatus, CreateTime) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");
            preparedStatement.setInt(1, order.getUserID());
            preparedStatement.setInt(2, order.getProductID());
            preparedStatement.setString(3, order.getOrderStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Order getOrderById(int orderID) throws SQLException {
        Order order = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE OrderID = ?");
            preparedStatement.setInt(1, orderID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setUserID(resultSet.getInt("UserID"));
                order.setProductID(resultSet.getInt("ProductID"));
                order.setOrderStatus(resultSet.getString("OrderStatus"));
                order.setCreateTime(resultSet.getTimestamp("CreateTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    @Override
    public List<Order> getUserOrders(int userID) throws SQLException {
        List<Order> orders = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE UserID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setUserID(resultSet.getInt("UserID"));
                order.setProductID(resultSet.getInt("ProductID"));
                order.setOrderStatus(resultSet.getString("OrderStatus"));
                order.setCreateTime(resultSet.getTimestamp("CreateTime"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    @Override
    public void updateOrderStatus(int orderID, String orderStatus) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE orders SET OrderStatus = ? WHERE OrderID = ?");
            preparedStatement.setString(1, orderStatus);
            preparedStatement.setInt(2, orderID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM orders ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setUserID(resultSet.getInt("UserID"));
                order.setProductID(resultSet.getInt("ProductID"));
                order.setOrderStatus(resultSet.getString("OrderStatus"));
                order.setCreateTime(resultSet.getTimestamp("CreateTime"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }
}

