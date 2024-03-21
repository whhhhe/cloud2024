package com.zmy.cloud.service;

import com.zmy.cloud.entities.Order;

public interface OrderService {
    void createOrder(Order order); //创建订单

    Order getById(Integer id);
}
