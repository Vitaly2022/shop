package com.vint.shop.service.impl;

import com.vint.shop.domain.Category;
import com.vint.shop.domain.Product;
import com.vint.shop.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductServiceImpl(productRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        Mockito.verify(productRepository).findAll();
    }

    @Test
    void saveProduct() {
        Product newProduct = createListOfProducts().get(0);
        underTest.saveProduct(newProduct);
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        Mockito.verify(productRepository).save(productArgumentCaptor.capture());
        Product productCapture = productArgumentCaptor.getValue();
        assertThat(productCapture).isEqualTo(newProduct);
    }

    @Test
    void viewDeleteProductFromId() {
        Product newProduct = new Product();
        newProduct.setId(7);
        newProduct.setName("TestCategory");
        productRepository.deleteById(newProduct.getId());
        ArgumentCaptor<Long> productArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(productRepository).deleteById(productArgumentCaptor.capture());
        Long i = productArgumentCaptor.getValue();
        Assertions.assertEquals(7, i);
    }

    boolean resultTest = false;

    @Test
    void trueIfFindProduct() {
        Product newProduct = new Product();
        newProduct.setId(3);
        newProduct.setName("TestCategory");
        when(productRepository.findById(newProduct.getId())).thenReturn(Optional.of(newProduct));
        if (productRepository.findById(newProduct.getId()).isPresent()) resultTest = true;
        assertThat(resultTest).isTrue();
    }

    @Test
    void updateProduct() {
        long testId = 5;
        Product newProduct = new Product();
        newProduct.setId(3);
        newProduct.setName("TestCategory");
        newProduct.setId(testId);
        productRepository.save(newProduct);
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        Mockito.verify(productRepository).save(productArgumentCaptor.capture());
        Product productCapture = productArgumentCaptor.getValue();
        assertThat(productCapture).isEqualTo(newProduct);

    }

    @Test
    void findAllByCategoryId() {
        Category newCategory = new Category();
        newCategory.setId(3);
        newCategory.setName("TestCategory");
        underTest.findAllByCategoryId(newCategory.getId());
        Mockito.verify(productRepository).findAllByCategoryId(newCategory.getId());
    }

    @Test
    void findById() {
        Product newProduct = new Product();
        newProduct.setId(3);
        newProduct.setName("TestCategory");
        productRepository.findById(newProduct.getId());
        Mockito.verify(productRepository).findById(newProduct.getId());
    }

    @Test
    void productsCount() {
        List<Product> products = createListOfProducts();
        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productRepository.findAll();
        Assertions.assertEquals(2, result.size());
    }

    private List<Product> createListOfProducts() {

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