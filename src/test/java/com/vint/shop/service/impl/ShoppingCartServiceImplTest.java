package com.vint.shop.service.impl;


import com.vint.shop.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceImplTest {

    private Map<Product, Integer> newCart() {
        Map<Product, Integer> cart = new LinkedHashMap<>();
        cart.put(newProduct(1, "Product1", BigDecimal.valueOf(10.15)), 1);
        cart.put(newProduct(2, "Product2", BigDecimal.valueOf(1)), 2);
        cart.put(newProduct(3, "Product3", BigDecimal.valueOf(2)), 3);
        cart.put(newProduct(4, "Product4", BigDecimal.valueOf(5.10)), 4);
        cart.put(newProduct(5, "Product5", BigDecimal.valueOf(10.10)), 5);

        return cart;
    }

    private Product newProduct(int id, String name, BigDecimal price) {

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);

        return product;
    }

    @Test
    void addSimilarProduct() {
        Map<Product,Integer> testCart = newCart();
        Product product = newProduct(5, "Product5", BigDecimal.valueOf(10.10));
        if (testCart.containsKey(product)) {
            testCart.replace(product, testCart.get(product) + 1);
        } else {
            testCart.put(product, 1);
        }

        for(Map.Entry<Product, Integer> entry: testCart.entrySet()) {
            System.out.println(entry.getKey().getName()+" value= "+entry.getValue());
        }
        Assertions.assertEquals(5,testCart.size());
    }

    @Test
    void  numberOfSimilarProduct() {
        Map<Product,Integer> testCart = newCart();
        Product product = newProduct(5, "Product5", BigDecimal.valueOf(10.10));
        if (testCart.containsKey(product)) {
            testCart.replace(product, testCart.get(product) + 1);
        } else {
            testCart.put(product, 1);
        }

        for(Map.Entry<Product, Integer> entry: testCart.entrySet()) {
            System.out.println(entry.getKey().getName()+" value= "+entry.getValue());
        }
        Assertions.assertEquals(6,testCart.get(product));
    }

    @Test
    void removeQuantityOfProduct() {
        Map <Product, Integer> testCart = newCart();
        Product product = newProduct(5, "Product5", BigDecimal.valueOf(10.10));
        testCart.replace(product, testCart.get(product)-1);
        Assertions.assertEquals(4,testCart.get(product));
    }

    @Test
    void clearProducts() {
        Map <Product, Integer> testCart = newCart();
        testCart.clear();
        Assertions.assertEquals(0,testCart.size());
    }

    @Test
    void productsInCart() throws UnsupportedOperationException {

        Map<Product, Integer> immutableCart = Collections.unmodifiableMap(new LinkedHashMap<Product, Integer>(newCart()));
        Throwable thrown = assertThrows(UnsupportedOperationException.class, () -> {
            immutableCart.put(newProduct(7, "Product3", BigDecimal.valueOf(2)), 3);
        });
        thrown.getMessage();
    }

    @Test
    void totalPrice() {
        Map <Product, Integer> testCart = newCart();
        BigDecimal total = testCart.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        System.out.println(total);
        Assertions.assertEquals(BigDecimal.valueOf(89.05),total);

    }

    @Test
    void TrueIfgetCart() {
        Map <Product, Integer> testCart = newCart();
        assertThat(testCart).isEqualTo(newCart());
    }
}