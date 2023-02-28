package com.vint.shop.repository;

import com.vint.shop.domain.Order;
import com.vint.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);


}
