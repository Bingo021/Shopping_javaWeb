package com.Shopping.dao.Impl;

import com.Shopping.dao.DeliveryAddressDao;
import com.Shopping.model.DeliveryAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDaoImpl implements DeliveryAddressDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DeliveryAddressDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDeliveryAddress(DeliveryAddress deliveryAddress) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO deliveryaddresses (UserID, RecipientName, RecipientPhone, RecipientAddress) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, deliveryAddress.getUserID());
            preparedStatement.setString(2, deliveryAddress.getRecipientName());
            preparedStatement.setString(3, deliveryAddress.getRecipientPhone());
            preparedStatement.setString(4, deliveryAddress.getRecipientAddress());
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
    public List<DeliveryAddress> getUserDeliveryAddresses(int userID) {
        List<DeliveryAddress> addresses = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM deliveryaddresses WHERE UserID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DeliveryAddress deliveryAddress = new DeliveryAddress();
                deliveryAddress.setDeliveryAddressID(resultSet.getInt("DeliveryAddressID"));
                deliveryAddress.setUserID(resultSet.getInt("UserID"));
                deliveryAddress.setRecipientName(resultSet.getString("RecipientName"));
                deliveryAddress.setRecipientPhone(resultSet.getString("RecipientPhone"));
                deliveryAddress.setRecipientAddress(resultSet.getString("RecipientAddress"));
                addresses.add(deliveryAddress);
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
        return addresses;
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE deliveryaddresses SET RecipientName=?, RecipientPhone=?, RecipientAddress=? WHERE DeliveryAddressID=?");
            preparedStatement.setString(1, deliveryAddress.getRecipientName());
            preparedStatement.setString(2, deliveryAddress.getRecipientPhone());
            preparedStatement.setString(3, deliveryAddress.getRecipientAddress());
            preparedStatement.setInt(4, deliveryAddress.getDeliveryAddressID());
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
    public void deleteDeliveryAddress(int deliveryAddressID) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM deliveryaddresses WHERE DeliveryAddressID=?");
            preparedStatement.setInt(1, deliveryAddressID);
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
    public DeliveryAddress getUserDeliveryAddress(int userID) {
        DeliveryAddress deliveryAddress = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM deliveryaddresses WHERE UserID=?");
            preparedStatement.setInt(1, userID);
            preparedStatement.executeQuery();
            while (resultSet.next()) {
                deliveryAddress = new DeliveryAddress();
                deliveryAddress.setDeliveryAddressID(resultSet.getInt("DeliveryAddressID"));
                deliveryAddress.setUserID(resultSet.getInt("UserID"));
                deliveryAddress.setRecipientName(resultSet.getString("RecipientName"));
                deliveryAddress.setRecipientPhone(resultSet.getString("RecipientPhone"));
                deliveryAddress.setRecipientAddress(resultSet.getString("RecipientAddress"));
            }
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
        return deliveryAddress;
    }
}
