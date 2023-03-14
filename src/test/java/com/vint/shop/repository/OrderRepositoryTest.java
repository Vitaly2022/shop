package com.vint.shop.repository;

import com.vint.shop.domain.Order;
import com.vint.shop.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void findByUser() {

        User userEva = new User();
        userEva.setId(1);
        userEva.setEmail("asd@gmail.com");
        userEva.setUsername("eva");
        userEva.setLogin("test123456");
        userEva.setPassword("Nfywq21@$55");
        userRepository.save(userEva);

        User userLiza = new User();
        userLiza.setId(2);
        userLiza.setEmail("liza@gmail.com");
        userLiza.setUsername("liza");
        userLiza.setLogin("liza123456");
        userLiza.setPassword("Klkjyq21@$55");
        userRepository.save(userLiza);

        Order newOrder = new Order();
        newOrder.setUser(userEva);
        newOrder.setId(1);

        Order newOrder2 = new Order();
        newOrder2.setUser(userLiza);
        newOrder2.setId(2);

        Order newOrder3 = new Order();
        newOrder3.setUser(userEva);
        newOrder3.setId(3);

        orderRepository.save(newOrder);
        orderRepository.save(newOrder2);
        orderRepository.save(newOrder3);

        List<Order> result = orderRepository.findByUser(userEva);
        Assertions.assertEquals(2, result.size());

    }
}