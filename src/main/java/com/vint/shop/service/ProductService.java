package com.vint.shop.service;

import com.vint.shop.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    boolean deleteProduct(Long id);

    boolean saveProduct(Product id);

    void updateProduct(Long id, Product product);

    long productsCount();

    List<Product> findAllByCategoryId(long categoryId);

    Product findById(long id);

    long count();
}
