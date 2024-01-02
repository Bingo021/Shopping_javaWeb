package com.Shopping.service.Impl;

import com.Shopping.dao.DeliveryAddressDao;
import com.Shopping.model.DeliveryAddress;
import com.Shopping.service.DeliveryAddressService;

import java.sql.SQLException;
import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressDao deliveryAddressDao;

    public DeliveryAddressServiceImpl() {

        deliveryAddressDao = null;
    }

    public DeliveryAddressServiceImpl(DeliveryAddressDao deliveryAddressDao) {
        this.deliveryAddressDao = deliveryAddressDao;
    }

    @Override
    public DeliveryAddress addDeliveryAddress(int userId, String recipientName, String recipientPhone, String recipientAddress) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setUserID(userId);
        deliveryAddress.setRecipientName(recipientName);
        deliveryAddress.setRecipientPhone(recipientPhone);
        deliveryAddress.setRecipientAddress(recipientAddress);

        deliveryAddressDao.addDeliveryAddress(deliveryAddress);

        return deliveryAddress;
    }

    @Override
    public List<DeliveryAddress> getDeliveryAddressesByUserId(int userId) {
        return deliveryAddressDao.getUserDeliveryAddresses(userId);
    }

    @Override
    public void updateDeliveryAddress(int userId, String newRecipientName, String newRecipientPhone, String newRecipientAddress) {
        try {
            DeliveryAddress existingAddress = deliveryAddressDao.getUserDeliveryAddress(userId);
            if (existingAddress != null) {
                existingAddress.setRecipientName(newRecipientName);
                existingAddress.setRecipientPhone(newRecipientPhone);
                existingAddress.setRecipientAddress(newRecipientAddress);

                deliveryAddressDao.updateDeliveryAddress(existingAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDeliveryAddress(int userId) {
        try {
            deliveryAddressDao.deleteDeliveryAddress(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

