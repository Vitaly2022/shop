package com.vint.shop.service;

import com.vint.shop.domain.OrderProductMap;

import java.util.List;

public interface OrderProductMapService {

    List<OrderProductMap> findAllByOrder_id(long id);
}
