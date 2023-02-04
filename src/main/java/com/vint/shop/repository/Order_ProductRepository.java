package com.vint.shop.repository;

import com.vint.shop.domain.Order_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_ProductRepository extends JpaRepository<Order_Product, Integer> {
}
