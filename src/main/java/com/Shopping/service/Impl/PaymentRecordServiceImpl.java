package com.Shopping.service.Impl;

import com.Shopping.model.PaymentRecord;
import com.Shopping.service.PaymentRecordService;

import java.math.BigDecimal;
import java.util.List;

public class PaymentRecordServiceImpl implements PaymentRecordService {
    @Override
    public PaymentRecord processPayment(int orderId, String paymentMethod, BigDecimal paymentAmount) {
        return null;
    }

    @Override
    public PaymentRecord getPaymentRecordById(int paymentRecordId) {
        return null;
    }

    @Override
    public List<PaymentRecord> getAllPaymentRecords() {
        return null;
    }
}

