package com.Shopping.service.Impl;

import com.Shopping.model.DeliveryAddress;
import com.Shopping.service.DeliveryAddressService;

import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Override
    public DeliveryAddress addDeliveryAddress(int userId, String recipientName, String recipientPhone, String recipientAddress) {
        return null;
    }

    @Override
    public List<DeliveryAddress> getDeliveryAddressesByUserId(int userId) {
        return null;
    }

    @Override
    public void updateDeliveryAddress(int addressId, String newRecipientName, String newRecipientPhone, String newRecipientAddress) {

    }

    @Override
    public void deleteDeliveryAddress(int addressId) {

    }
}

