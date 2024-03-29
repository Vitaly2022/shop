package com.vint.shop.service.impl;

import com.vint.shop.domain.Order;
import com.vint.shop.repository.OrderRepository;
import com.vint.shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    protected OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Transactional
    @Override
    public boolean deleteOrder(Long orderId) {
        if (orderRepository.findById(orderId).isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    public Optional<Order> findOrder(Long id) {
        return orderRepository.findById(id);
    }


}
