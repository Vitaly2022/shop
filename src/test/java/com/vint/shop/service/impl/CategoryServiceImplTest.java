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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        Category categoryCapture = categoryArgumentCaptor.getValue();
        assertThat(categoryCapture).isEqualTo(newCategory);
    }

    @Test
    void viewDeleteCategory() {
        Category newCategory = new Category();
        newCategory.setId(3);
        newCategory.setName("TestCategory");
        categoryRepository.deleteById(newCategory.getId());
        ArgumentCaptor<Long> categoryArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(categoryRepository).deleteById(categoryArgumentCaptor.capture());
        Long i = categoryArgumentCaptor.getValue();
        Assertions.assertEquals(3, i);
    }

    boolean resultTest = false;

    @Test
    void trueIfFindCategory() {
        Category newCategory = new Category();
        newCategory.setId(3);
        newCategory.setName("TestCategory");
        when(categoryRepository.findById(newCategory.getId())).thenReturn(Optional.of(newCategory));
        if (categoryRepository.findById(newCategory.getId()).isPresent()) resultTest = true;
        assertThat(resultTest).isTrue();
    }


}