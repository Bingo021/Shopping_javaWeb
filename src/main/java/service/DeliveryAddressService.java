package service;

import model.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressService {
    void addDeliveryAddress(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> getUserDeliveryAddresses(int userId);
    void updateDeliveryAddress(DeliveryAddress deliveryAddress) throws SQLException;
    void deleteDeliveryAddress(int deliveryAddressId) throws SQLException;
}
