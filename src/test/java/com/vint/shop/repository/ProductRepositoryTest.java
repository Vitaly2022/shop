package com.vint.shop.repository;

import com.vint.shop.domain.Category;
import com.vint.shop.domain.Manufacturer;
import com.vint.shop.domain.Product;
import com.vint.shop.domain.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    void OkIffindByName() {
        Product testProduct = createProduct();
        productRepository.save(testProduct);
        Product result = productRepository.findByName(testProduct.getName());
        Assertions.assertEquals("TestProduct", testProduct.getName());
    }

    @Test
    void OkiFfindAllByCategoryId() {
       Product testProduct = createProduct();
       productRepository.save(testProduct);
       List <Product> result = productRepository.findAllByCategoryId(testProduct.getCategory().getId());
        Assertions.assertEquals(1,result.size());
    }

    private Product createProduct () {
        Supplier supplier = new Supplier();
        supplier.setId(1);
        supplierRepository.save(supplier);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(1);
        manufacturerRepository.save(manufacturer);

        Category category = new Category();
        category.setId(1);
        category.setName("TestCategory");
        categoryRepository.save(category);

        Product newProduct = new Product();
        newProduct.setId(1);
        newProduct.setName("TestProduct");
        newProduct.setManufacturer(manufacturer);
        newProduct.setSupplier(supplier);
        newProduct.setCategory(category);

        return newProduct;
    }
}