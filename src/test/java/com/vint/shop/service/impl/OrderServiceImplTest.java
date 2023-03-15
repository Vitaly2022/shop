package com.vint.shop.service.impl;

import com.vint.shop.domain.Order;
import com.vint.shop.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrderServiceImpl(orderRepository);
    }

    @Test
    void saveOrder() {
        Order newOrder = new Order();
        newOrder.setId(1);
        underTest.saveOrder(newOrder);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);
        Mockito.verify(orderRepository).save(orderArgumentCaptor.capture());
        Order orderCapture = orderArgumentCaptor.getValue();
        assertThat(orderCapture).isEqualTo(newOrder);
    }

    @Test
    void viewDeleteOrder() {
        Order newOrder = new Order();
        newOrder.setId(11);
        orderRepository.deleteById(newOrder.getId());
        ArgumentCaptor<Long> orderArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(orderRepository).deleteById(orderArgumentCaptor.capture());
        Long i = orderArgumentCaptor.getValue();
        Assertions.assertEquals(11, i);
    }

    boolean resultTest = false;

    @Test
    void trueIfFindOrder() {
        Order newOrder = new Order();
        newOrder.setId(11);
        when(orderRepository.findById(newOrder.getId())).thenReturn(Optional.of(newOrder));
        if (orderRepository.findById(newOrder.getId()).isPresent()) resultTest = true;
        assertThat(resultTest).isTrue();
    }

    @Test
    void findOrder() {
        Order newOrder = new Order();
        newOrder.setId(1);
        orderRepository.findById(newOrder.getId());
        Mockito.verify(orderRepository).findById(newOrder.getId());
    }
}