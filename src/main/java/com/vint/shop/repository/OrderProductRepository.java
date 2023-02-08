package com.vint.shop.repository;

import com.vint.shop.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
