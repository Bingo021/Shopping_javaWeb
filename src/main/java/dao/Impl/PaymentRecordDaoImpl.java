package dao.Impl;

import dao.PaymentRecordDao;
import model.PaymentRecord;

import java.sql.*;
import java.util.List;

public class PaymentRecordDaoImpl implements PaymentRecordDao{
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public PaymentRecord getPaymentRecordById(int paymentRecordID) {
        return null;
    }

    @Override
    public List<PaymentRecord> getPaymentRecordsByOrderId(int orderID) {
        return null;
    }

    @Override
    public List<PaymentRecord> getAllPaymentRecords() {
        return null;
    }

    @Override
    public void updatePaymentStatus(int paymentRecordID, String paymentStatus) {

    }
}
