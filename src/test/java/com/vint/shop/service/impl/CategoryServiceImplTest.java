package com.vint.shop.service.impl;

import com.vint.shop.domain.Category;
import com.vint.shop.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        verify(categoryRepository).findAll();
    }

    @Test
    void saveCategory() {
        Category newCategory = new Category();
        newCategory.setId(3);
        newCategory.setName("TestCategory");
        underTest.saveCategory(newCategory);
        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);//перехватываем
        verify(categoryRepository).save(categoryArgumentCaptor.capture());//проверяем
        Category categoryCapture = categoryArgumentCaptor.getValue();
        assertThat(categoryCapture).isEqualTo(newCategory);
    }

    @Test
    void viewDeleteCategory() {
        Category newCategory = new Category();
        newCategory.setId(3);
        newCategory.setName("TestCategory");
        categoryRepository.deleteById(newCategory.getId());
        ArgumentCaptor<Long> categoryArgumentCaptor = ArgumentCaptor.forClass(Long.class);//перехватываем
        verify(categoryRepository).deleteById(categoryArgumentCaptor.capture());//проверяем
        Long i = categoryArgumentCaptor.getValue();
        Assertions.assertEquals(3, i);
    }
}