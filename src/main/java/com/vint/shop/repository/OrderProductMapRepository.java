package com.vint.shop.repository;

import com.vint.shop.domain.Order;
import com.vint.shop.domain.OrderProductMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductMapRepository extends JpaRepository<OrderProductMap, Long> {

//    List<OrderProductMap> findByOrder(Order order);
//
//    List<OrderProductMap> findAllByOrder(Order order);

    List<OrderProductMap> findAllByOrderid(Long id);


}
