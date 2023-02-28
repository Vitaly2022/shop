package com.vint.shop.repository;

import com.vint.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findAllByOrderByIdAsc();

}
