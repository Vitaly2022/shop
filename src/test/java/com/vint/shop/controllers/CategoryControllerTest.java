package com.vint.shop.controllers;

import com.vint.shop.domain.Category;
import com.vint.shop.repository.CategoryRepository;
import com.vint.shop.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CategoryControllerTest {
    private MockMvc mockMvc;
    @Mock
    private CategoryServiceImpl categoryServiceImpl;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(new CategoryController(categoryServiceImpl, categoryRepository))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void CategoryControllerStatus1() throws Exception {
        this.mockMvc.perform(get("/admin/category")).andExpect(status().isOk())
                .andExpect(view().name("admin/category/category")).andDo(print());
    }

    @Test
    public void CategoryControllerPostStatus1False() throws Exception {
        this.mockMvc.perform(post("/admin/category")).andExpect(status().isOk());
        Category newCategoryForm = new Category();
        Mockito.when(categoryServiceImpl.saveCategory(newCategoryForm)).thenReturn(false);
        if (!categoryServiceImpl.saveCategory(newCategoryForm))
            this.mockMvc.perform(post("/admin/category"))
                    .andExpect(view().name("admin/category")).andDo(print());
    }

    @Test
    public void CategoryControllerPostStatus2True() throws Exception {
        this.mockMvc.perform(post("/admin/category")).andExpect(status().isOk());
        Category newCategoryForm = new Category();
        Mockito.when(categoryServiceImpl.saveCategory(newCategoryForm)).thenReturn(true);

        if (!categoryServiceImpl.saveCategory(newCategoryForm))
            this.mockMvc.perform(post("/admin/category"))
                    .andExpect(view().name("admin/category")).andDo(print());

        else this.mockMvc.perform(post("/admin/category"))
                .andExpect(redirectedUrl("/admin/category")).andDo(print());
    }

    @Test
    public void CategoryControllerStatus3Delete() throws Exception {
        Category newCategoru = new Category();
        newCategoru.setId(1);
        long id= newCategoru.getId();
        this.mockMvc.perform(get("/admin/category/delete/"+id)).andExpect(status().is3xxRedirection());
    }

    @Test
    public void CategoryControllerEditStatus1() throws Exception {
        Category newCategory = new Category();
        newCategory.setId(1);
        Mockito.when(categoryRepository.existsById(newCategory.getId())).thenReturn(false);
        if (!categoryRepository.existsById(newCategory.getId()))
            this.mockMvc.perform(get("/admin/category"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("admin/category/category"))
                    .andDo(print());
        else this.mockMvc.perform(get("/admin/category/edit/*"))
                .andExpect(view().name("admin/category/editcategory"))
                .andDo(print());
    }
    @Test
    public void CategoryControllerPostEditStatus() throws Exception {
        Category newCategory = new Category();
        newCategory.setId(1);
        Mockito.when(categoryRepository.findById(newCategory.getId())).thenReturn(Optional.of(newCategory));
        Category category = categoryRepository.findById(newCategory.getId()).get();
        categoryRepository.save(category);
        long i = newCategory.getId();
        this.mockMvc.perform(post("/admin/category/edit/" + i)
                        .param("name", "TestName"))
                .andExpect(redirectedUrl("/admin/category"));
    }
}