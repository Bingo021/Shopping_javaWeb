package com.Shopping.service.Impl;

import com.Shopping.dao.OrderDetailDao;
import com.Shopping.model.OrderDetail;
import com.Shopping.service.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao;

    public OrderDetailServiceImpl(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailDao.addOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailDao.getOrderDetailsByOrderId(orderId);
    }
}

