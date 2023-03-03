package com.vint.shop.domain.service;

import com.vint.shop.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    boolean deleteCategory(Long id);

    boolean saveCategory(Category id);


}
