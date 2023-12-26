package dao.Impl;

import dao.DeliveryAddressDao;
import model.DeliveryAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDaoImpl implements DeliveryAddressDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DeliveryAddressDaoImpl() {
        try {
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
                int deliveryAddressID = resultSet.getInt("DeliveryAddressID");
                userID = resultSet.getInt("UserID");
                String recipientName = resultSet.getString("RecipientName");
                String recipientPhone = resultSet.getString("RecipientPhone");
                String recipientAddress = resultSet.getString("RecipientAddress");
                DeliveryAddress address = new DeliveryAddress(deliveryAddressID, userID, recipientName, recipientPhone, recipientAddress);
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
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
        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
