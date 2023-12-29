package service;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    void addOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetailsByOrderId(int orderId);
}

