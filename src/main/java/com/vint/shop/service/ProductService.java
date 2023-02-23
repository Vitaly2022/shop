package com.vint.shop.service;

import com.vint.shop.domain.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();

    boolean deleteProduct(Long id);

    boolean saveProduct(Product id);

    void updateProduct(Long id, Product product);

}
