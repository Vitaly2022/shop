package com.vint.shop.service.impl;

import com.vint.shop.domain.Category;
import com.vint.shop.repository.CategoryRepository;
import com.vint.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean saveCategory(Category category) {
        Category categoryFromDB = categoryRepository.findByName(category.getName());

        if (categoryFromDB != null) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        if (categoryRepository.findById(categoryId).isPresent()) {
            categoryRepository.deleteById(categoryId);
            return true;
        }
        return false;
    }
}

