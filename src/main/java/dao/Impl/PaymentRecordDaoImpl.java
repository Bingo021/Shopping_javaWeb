package dao.Impl;

import dao.PaymentRecordDao;
import model.PaymentRecord;

import java.util.List;

public class PaymentRecordDaoImpl implements PaymentRecordDao{

    @Override
    public void addPaymentRecord(PaymentRecord paymentRecord) {

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
