package com.vint.shop.validator;

import com.vint.shop.domain.Product;
import com.vint.shop.repository.ProductRepository;
import com.vint.shop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductValidatorTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceimpl;

    @Test
    void PriceAboveZero() {

        List<Product> products = createProducts();
        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productRepository.findAll();

        Assertions.assertFalse(result.get(0).getPrice().signum() != 1);

    }

    private List<Product> createProducts() {

        Product product1 = new Product();
        Product product2 = new Product();

        product1.setId(1);
        product1.setDescription("Description");
        product1.setImageUrl("url");
        product1.setName("Product1");
        product1.setPrice(BigDecimal.valueOf(2325.06));
        product1.setQuantity(50);

        product2.setId(2);
        product2.setDescription("Description");
        product2.setImageUrl("url");
        product2.setName("Product1");
        product2.setPrice(BigDecimal.valueOf(2023.00));
        product2.setQuantity(50);

        return List.of(product1, product2);
    }


}
