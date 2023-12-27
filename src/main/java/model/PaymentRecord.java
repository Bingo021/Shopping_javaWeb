package model;

import java.security.Timestamp;

public class PaymentRecord {
    private int paymentRecordID;
    private int orderID;
    private String paymentMethod; // 支付方式，例如：支付宝、微信支付等
    private double paymentAmount; // 定点数，用于存储支付金额，允许小数点后两位
    private String paymentStatus; // 支付状态，例如：待支付、已支付等
    private java.sql.Timestamp paymentTime;

    public int getPaymentRecordID() {
        return paymentRecordID;
    }

    public void setPaymentRecordID(int paymentRecordID) {
        this.paymentRecordID = paymentRecordID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public java.sql.Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(java.sql.Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }
}
