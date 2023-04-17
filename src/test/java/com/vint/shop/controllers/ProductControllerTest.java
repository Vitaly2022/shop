package com.vint.shop.controllers;

import com.vint.shop.domain.Product;
import com.vint.shop.repository.ProductRepository;
import com.vint.shop.service.controllers.ProductController;
import com.vint.shop.service.impl.CategoryServiceImpl;
import com.vint.shop.service.impl.ManufacturerServiceImpl;
import com.vint.shop.service.impl.ProductServiceImpl;
import com.vint.shop.service.impl.SupplierServiceImpl;
import com.vint.shop.validator.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    protected ProductServiceImpl productServiceImpl;

    @Mock
    protected CategoryServiceImpl categoryServiceImpl;

    @Mock
    protected ManufacturerServiceImpl manufacturerServiceImpl;

    @Mock
    protected ProductRepository productRepository;

    @Mock
    protected SupplierServiceImpl supplierServiceImpl;

    @Mock
    protected ProductValidator productValidator;

    @BeforeEach
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productServiceImpl, categoryServiceImpl, manufacturerServiceImpl, productRepository, supplierServiceImpl, productValidator))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void ProductControllerStatus() throws Exception {
        this.mockMvc.perform(get("/admin/product")).andExpect(status().isOk())
                .andExpect(view().name("admin/product/product")).andDo(print());
    }

    @Test
    public void ProductControllerStatus1() throws Exception {
        this.mockMvc.perform(get("/admin/product/new")).andExpect(status().isOk())
                .andExpect(view().name("admin/product/newproduct")).andDo(print());
    }

    @Test
    public void ProductControllerStatus2() throws Exception {
        Product product = new Product();
        product.setId(1);
        long id = product.getId();
        this.mockMvc.perform(get("/admin/product/delete/" + id)).andExpect(status().is3xxRedirection());
    }

    @Test
    public void CategoryControllerPostStatus3() throws Exception {
        Product product = new Product();
        product.setId(1);
        long id = product.getId();
        productRepository.save(product);
        if (!productRepository.existsById(id))
            this.mockMvc.perform(post("/admin/product/edit/" + id)).andExpect(status().is3xxRedirection());
        else this.mockMvc.perform(post("/admin/product/edit/" + id)).andExpect(status().isOk())
                .andExpect(view().name("admin/product/editproduct")).andDo(print());
    }
}