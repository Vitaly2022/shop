package com.vint.shop.service;

import com.vint.shop.domain.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    void clearProducts();

    Map<Product, Integer> productsInCart();

    BigDecimal totalPrice();

    void cartCheckout();
}
