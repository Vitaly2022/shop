package com.vint.shop.controllers;

import com.vint.shop.domain.Category;
import com.vint.shop.repository.CategoryRepository;
import com.vint.shop.service.impl.CategoryServiceImpl;
import com.vint.shop.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    protected ProductServiceImpl productServiceImpl;


    @GetMapping(value = {"/", "/index", "/home"})
    public String home(Model model) {
        model.addAttribute("products", productServiceImpl.findAll());
        model.addAttribute("productsCount", productServiceImpl.productsCount());
        model.addAttribute("categories", categoryServiceImpl.findAll());
        return "index";
    }

    @GetMapping(value = {"/about"})
    public String about() {

        return "about";
    }

    @RequestMapping("/searchByCategory/{id}")
    public String homePost(@PathVariable("id") long categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).get();
        model.addAttribute("productCategory", productServiceImpl.findAllByCategoryId(categoryId));
        model.addAttribute("productsCount", productServiceImpl.productsCount());
        model.addAttribute("category", category);
        return "productfromcategory";
    }

}
