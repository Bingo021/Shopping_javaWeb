package com.Shopping.service.Impl;

import com.Shopping.dao.PaymentRecordDao;
import com.Shopping.model.PaymentRecord;
import com.Shopping.service.PaymentRecordService;

import java.util.List;

public class PaymentRecordServiceImpl implements PaymentRecordService {
    private PaymentRecordDao paymentRecordDao;

    public PaymentRecordServiceImpl(PaymentRecordDao paymentRecordDao) {
        this.paymentRecordDao = paymentRecordDao;
    }

    @Override
    public void addPaymentRecord(PaymentRecord paymentRecord) {
        paymentRecordDao.addPaymentRecord(paymentRecord);
    }

    @Override
    public PaymentRecord getPaymentRecordById(int paymentRecordId) {
        return paymentRecordDao.getPaymentRecordById(paymentRecordId);
    }

    @Override
    public List<PaymentRecord> getPaymentRecordsByOrderId(int orderId) {
        return paymentRecordDao.getPaymentRecordsByOrderId(orderId);
    }

    @Override
    public List<PaymentRecord> getAllPaymentRecords() {
        return paymentRecordDao.getAllPaymentRecords();
    }

    @Override
    public void updatePaymentStatus(int paymentRecordId, String paymentStatus) {
        paymentRecordDao.updatePaymentStatus(paymentRecordId, paymentStatus);
    }
}

