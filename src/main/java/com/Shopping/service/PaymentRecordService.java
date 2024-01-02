package com.Shopping.service;

import com.Shopping.model.PaymentRecord;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRecordService {
    PaymentRecord processPayment(int orderId, String paymentMethod, BigDecimal paymentAmount);

    PaymentRecord getPaymentRecordById(int paymentRecordId);

    List<PaymentRecord> getAllPaymentRecords(); // 获取所有支付记录（管理员视角）
}
