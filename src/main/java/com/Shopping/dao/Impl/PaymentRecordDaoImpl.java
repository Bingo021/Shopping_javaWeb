package com.Shopping.dao.Impl;

import com.Shopping.dao.PaymentRecordDao;
import com.Shopping.model.PaymentRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRecordDaoImpl implements PaymentRecordDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PaymentRecordDaoImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "zjh", "zjh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPaymentRecord(PaymentRecord paymentRecord) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO paymentrecords (OrderID, PaymentMethod, PaymentAmount, PaymentStatus, PaymentTime) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, paymentRecord.getOrderID());
            preparedStatement.setString(2, paymentRecord.getPaymentMethod());
            preparedStatement.setDouble(3, paymentRecord.getPaymentAmount());
            preparedStatement.setString(4, paymentRecord.getPaymentStatus());
            preparedStatement.setTimestamp(5, paymentRecord.getPaymentTime());
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
    public PaymentRecord getPaymentRecordById(int paymentRecordID) {
        PaymentRecord paymentRecord = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM paymentrecords WHERE PaymentRecordID = ?");
            preparedStatement.setInt(1, paymentRecordID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                paymentRecord = new PaymentRecord();
                paymentRecord.setPaymentRecordID(resultSet.getInt("PaymentRecordID"));
                paymentRecord.setOrderID(resultSet.getInt("OrderID"));
                paymentRecord.setPaymentMethod(resultSet.getString("PaymentMethod"));
                paymentRecord.setPaymentAmount(resultSet.getDouble("PaymentAmount"));
                paymentRecord.setPaymentStatus(resultSet.getString("PaymentStatus"));
                paymentRecord.setPaymentTime(resultSet.getTimestamp("PaymentTime"));
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
        return paymentRecord;
    }

    @Override
    public List<PaymentRecord> getPaymentRecordsByOrderId(int orderID) {
        List<PaymentRecord> paymentRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM paymentrecords WHERE OrderID = ?");
            preparedStatement.setInt(1, orderID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PaymentRecord paymentRecord = new PaymentRecord();
                paymentRecord.setPaymentRecordID(resultSet.getInt("PaymentRecordID"));
                paymentRecord.setOrderID(resultSet.getInt("OrderID"));
                paymentRecord.setPaymentMethod(resultSet.getString("PaymentMethod"));
                paymentRecord.setPaymentAmount(resultSet.getDouble("PaymentAmount"));
                paymentRecord.setPaymentStatus(resultSet.getString("PaymentStatus"));
                paymentRecord.setPaymentTime(resultSet.getTimestamp("PaymentTime"));
                paymentRecords.add(paymentRecord);
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
        return paymentRecords;
    }

    @Override
    public List<PaymentRecord> getAllPaymentRecords() {
        List<PaymentRecord> paymentRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM paymentrecords");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PaymentRecord paymentRecord = new PaymentRecord();
                paymentRecord.setPaymentRecordID(resultSet.getInt("PaymentRecordID"));
                paymentRecord.setOrderID(resultSet.getInt("OrderID"));
                paymentRecord.setPaymentMethod(resultSet.getString("PaymentMethod"));
                paymentRecord.setPaymentAmount(resultSet.getDouble("PaymentAmount"));
                paymentRecord.setPaymentStatus(resultSet.getString("PaymentStatus"));
                paymentRecord.setPaymentTime(resultSet.getTimestamp("PaymentTime"));
                paymentRecords.add(paymentRecord);
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
        return paymentRecords;
    }

    @Override
    public void updatePaymentStatus(int paymentRecordID, String paymentStatus) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE paymentrecords SET PaymentStatus = ? WHERE PaymentRecordID = ?");
            preparedStatement.setString(1, paymentStatus);
            preparedStatement.setInt(2, paymentRecordID);
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
}
