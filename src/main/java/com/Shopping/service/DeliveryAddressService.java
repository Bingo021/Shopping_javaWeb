package com.Shopping.service;

import com.Shopping.model.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    DeliveryAddress addDeliveryAddress(int userId, String recipientName, String recipientPhone, String recipientAddress);

    List<DeliveryAddress> getDeliveryAddressesByUserId(int userId);

    void updateDeliveryAddress(int addressId, String newRecipientName, String newRecipientPhone, String newRecipientAddress);

    void deleteDeliveryAddress(int addressId);
}
