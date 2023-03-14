package com.vint.shop.repository;

import com.vint.shop.domain.Order;
import com.vint.shop.domain.OrderProductMap;
import com.vint.shop.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class OrderProductMapRepositoryTest {
    @Autowired
    private OrderProductMapRepository orderProductMapRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void findAllByOrderid() {
        Order newOrder = new Order();
        newOrder.setId(1);
        newOrder.setDescription("test");
        orderRepository.save(newOrder);

        Product newProduct = new Product();
        newProduct.setId(1);
        newProduct.setName("TestProduct");
        productRepository.save(newProduct);

        OrderProductMap orderProductMap = new OrderProductMap();
        orderProductMap.setId(1);
        orderProductMap.setOrder(newOrder);
        orderProductMap.setOrderid(newOrder.getId());
        orderProductMap.setProduct(newProduct);
        orderProductMapRepository.save(orderProductMap);

        OrderProductMap orderProductMap2 = new OrderProductMap();
        orderProductMap2.setId(3);
        orderProductMap2.setOrder(newOrder);
        orderProductMap2.setOrderid(5L);
        orderProductMap2.setProduct(newProduct);
        orderProductMapRepository.save(orderProductMap2);

        OrderProductMap orderProductMap3 = new OrderProductMap();
        orderProductMap3.setId(2);
        orderProductMap3.setOrder(newOrder);
        orderProductMap3.setOrderid(newOrder.getId());
        orderProductMap3.setProduct(newProduct);
        orderProductMapRepository.save(orderProductMap3);

        List<OrderProductMap> result = orderProductMapRepository.findAllByOrderid(newOrder.getId());
        Assertions.assertEquals(2, result.size());


    }
}