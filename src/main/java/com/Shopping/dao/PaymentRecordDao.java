package com.Shopping.dao;

import com.Shopping.model.PaymentRecord;

import java.util.List;

public interface PaymentRecordDao {
    void addPaymentRecord(PaymentRecord paymentRecord);

    PaymentRecord getPaymentRecordById(int paymentRecordID);

    List<PaymentRecord> getPaymentRecordsByOrderId(int orderID);

    List<PaymentRecord> getAllPaymentRecords();

    void updatePaymentStatus(int paymentRecordID, String paymentStatus);
}
