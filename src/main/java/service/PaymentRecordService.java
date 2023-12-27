package service;

import model.PaymentRecord;

import java.util.List;

public interface PaymentRecordService {
    void addPaymentRecord(PaymentRecord paymentRecord);
    PaymentRecord getPaymentRecordById(int paymentRecordId);
    List<PaymentRecord> getPaymentRecordsByOrderId(int orderId);
    List<PaymentRecord> getAllPaymentRecords();
    void updatePaymentStatus(int paymentRecordId, String paymentStatus);
}
