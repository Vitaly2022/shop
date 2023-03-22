package com.vint.shop.controllers;

import com.vint.shop.domain.Category;
import com.vint.shop.repository.CategoryRepository;
import com.vint.shop.service.impl.CategoryServiceImpl;
import com.vint.shop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class HomeControllerTest {

    private MockMvc mockMvc;
    @Mock
    private CategoryServiceImpl categoryServiceImpl;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(categoryServiceImpl, categoryRepository, productService))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void HomeControllerStatus() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("index")).andDo(print());
    }

    @Test
    public void HomeControllerStatus1() throws Exception {
        this.mockMvc.perform(get("/index")).andExpect(status().isOk())
                .andExpect(view().name("index")).andDo(print());
    }

    @Test
    public void HomeControllerStatus2() throws Exception {
        this.mockMvc.perform(get("/home")).andExpect(status().isOk())
                .andExpect(view().name("index")).andDo(print());
    }

    @Test
    public void HomeControllerStatus3() throws Exception {
        this.mockMvc.perform(get("/about")).andExpect(status().isOk())
                .andExpect(view().name("about")).andDo(print());
    }

    @RequestMapping("/searchByCategory/{id}")
    public String homePost(@PathVariable("id") long categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).get();
        return "productfromcategory";
    }

    @Test
    public void HomeControllerStatus4() throws Exception {
        Category newCategory = new Category();
        newCategory.setId(1);
        long i = newCategory.getId();
        Mockito.when(categoryRepository.findById(newCategory.getId())).thenReturn(Optional.of(newCategory));
        this.mockMvc.perform(get("/searchByCategory/" + i)).andExpect(status().isOk())
                .andExpect(view().name("productfromcategory")).andDo(print());
    }

    @Test
    public void HomeControllerStatus5() throws Exception {
        Category newCategory = new Category();
        newCategory.setId(1);
        long i = newCategory.getId();
        Mockito.when(categoryRepository.findById(newCategory.getId())).thenReturn(Optional.of(newCategory));
        this.mockMvc.perform(post("/searchByCategory/" + i)).andExpect(status().isOk())
                .andExpect(view().name("productfromcategory")).andDo(print());
    }


}