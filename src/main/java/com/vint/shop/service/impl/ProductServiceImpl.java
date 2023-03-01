package com.vint.shop.service.impl;

import com.vint.shop.domain.Product;
import com.vint.shop.repository.ProductRepository;
import com.vint.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    protected ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean saveProduct(Product product) {
        Product productFromDB = productRepository.findByName(product.getName());

        if (productFromDB != null) {
            return false;
        }
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public void updateProduct(Long id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    @Override
    public long productsCount() {
        return productRepository.count();
    }

    @Override
    public List<Product> findAllByCategoryId(long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Product> findAllByOrderByIdAsc() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public long count() {
        return productRepository.count();
    }
}
