package dao.Impl;

import dao.OrderDetailDao;
import model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public OrderDetailDaoImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO orderdetails (OrderID, ProductID, Quantity, Price, TotalPrice) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, orderDetail.getOrderID());
            preparedStatement.setInt(2, orderDetail.getProductID());
            preparedStatement.setInt(3, orderDetail.getQuantity());
            preparedStatement.setDouble(4, orderDetail.getPrice());
            preparedStatement.setDouble(5, orderDetail.getTotalPrice());
            preparedStatement.executeUpdate();
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
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderID) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM orderdetails WHERE OrderID = ?");
            preparedStatement.setInt(1, orderID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailID(resultSet.getInt("OrderDetailID"));
                orderDetail.setProductID(resultSet.getInt("ProductID"));
                orderDetail.setQuantity(resultSet.getInt("Quantity"));
                orderDetail.setPrice(resultSet.getDouble("Price"));
                orderDetail.setTotalPrice(resultSet.getDouble("TotalPrice"));
                orderDetails.add(orderDetail);
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
        return orderDetails;
    }
}
