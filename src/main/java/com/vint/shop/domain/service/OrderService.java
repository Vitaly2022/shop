package com.vint.shop.domain.service;

import com.vint.shop.domain.Order;

public interface OrderService {

    void saveOrder(Order order);

    boolean deleteOrder(Long id);

}
