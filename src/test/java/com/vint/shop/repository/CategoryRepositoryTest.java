package com.vint.shop.repository;

import com.vint.shop.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void OkifFindCategoryByName() {
        Category newCategory = new Category();
        newCategory.setId(3);
        newCategory.setName("TestCategory");
        categoryRepository.save(newCategory);
        Category result = categoryRepository.findByName(newCategory.getName());
        Assertions.assertEquals("TestCategory", result.getName());
    }
}