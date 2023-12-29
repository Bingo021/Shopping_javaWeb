package com.Shopping.dao;

import com.Shopping.model.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    void addOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetailsByOrderId(int orderID);
}
