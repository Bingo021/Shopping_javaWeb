package com.Shopping.dao;

import com.Shopping.model.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressDao {
    void addDeliveryAddress(DeliveryAddress DeliveryAddress);

    List<DeliveryAddress> getUserDeliveryAddresses(int userID);

    void updateDeliveryAddress(DeliveryAddress DeliveryAddress) throws SQLException;

    void deleteDeliveryAddress(int deliveryAddressID) throws SQLException;
}
