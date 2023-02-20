package com.vint.shop.repository;

import com.vint.shop.domain.OrderProductMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductMapRepository extends JpaRepository<OrderProductMap, Long> {
}
