package com.Shopping.service.Impl;

import com.Shopping.dao.Impl.PaymentRecordDaoImpl;
import com.Shopping.dao.PaymentRecordDao;
import com.Shopping.model.PaymentRecord;
import com.Shopping.service.PaymentRecordService;

import java.math.BigDecimal;
import java.util.List;

public class PaymentRecordServiceImpl implements PaymentRecordService {
    private final PaymentRecordDao paymentRecordDao = new PaymentRecordDaoImpl();

    public PaymentRecordServiceImpl() {

    }

    @Override
    public PaymentRecord processPayment(int orderId, String paymentMethod, BigDecimal paymentAmount) {
        PaymentRecord paymentRecord = new PaymentRecord(orderId, paymentMethod, paymentAmount);
        paymentRecordDao.addPaymentRecord(paymentRecord);
        return paymentRecord;
    }

    @Override
    public PaymentRecord getPaymentRecordById(int paymentRecordId) {
        return paymentRecordDao.getPaymentRecordById(paymentRecordId);
    }

    @Override
    public List<PaymentRecord> getAllPaymentRecords() {
        return paymentRecordDao.getAllPaymentRecords();
    }
}

