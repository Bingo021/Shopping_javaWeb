package service.Impl;

import dao.DeliveryAddressDao;
import model.DeliveryAddress;
import service.DeliveryAddressService;

import java.sql.SQLException;
import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private DeliveryAddressDao deliveryAddressDao;

    public DeliveryAddressServiceImpl(DeliveryAddressDao deliveryAddressDao) {
        this.deliveryAddressDao = deliveryAddressDao;
    }

    @Override
    public void addDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressDao.addDeliveryAddress(deliveryAddress);
    }

    @Override
    public List<DeliveryAddress> getUserDeliveryAddresses(int userId) {
        return deliveryAddressDao.getUserDeliveryAddresses(userId);
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) throws SQLException {
        deliveryAddressDao.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public void deleteDeliveryAddress(int deliveryAddressId) throws SQLException {
        deliveryAddressDao.deleteDeliveryAddress(deliveryAddressId);
    }
}

