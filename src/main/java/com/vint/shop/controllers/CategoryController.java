package com.vint.shop.controllers;

import com.vint.shop.domain.Category;
import com.vint.shop.repository.CategoryRepository;
import com.vint.shop.service.impl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/category")

public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    protected CategoryServiceImpl categoryServiceImpl;

    @Autowired
    protected CategoryRepository categoryRepository;

    @GetMapping
    public String viewCategory(Model model) {
        model.addAttribute("allCategory", categoryServiceImpl.findAll());
        model.addAttribute("newCategoryForm", new Category());
        return "admin/category/category";
    }

    @PostMapping
    public String newCategory(@ModelAttribute("newCategoryForm") Category newCategoryForm, Model model) {

        if (!categoryServiceImpl.saveCategory(newCategoryForm)) {
            model.addAttribute("categorynameError", "This category is taken");
            return "admin/category";
        }
        logger.debug(String.format("Category with id: %s successfully created.", newCategoryForm.getId()));
        return "redirect:/admin/category";

    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        categoryServiceImpl.deleteCategory(id);
        logger.debug(String.format("Category with id: %s has been successfully deleted.", id));

        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") long id, Model model) {
        if (!categoryRepository.existsById(id)) {
            return "redirect:admin/category";
        }
        Category category = categoryRepository.findById(id).get();
        ArrayList<Category> editCategory = new ArrayList<>();
        editCategory.add(category);
        model.addAttribute("editCategory", editCategory);
        return "admin/category/editcategory";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") long id, @RequestParam String name, Model model) {
        Category category = categoryRepository.findById(id).get();
        category.setName(name);
        categoryRepository.save(category);
        logger.debug(String.format("Category with id: %s has been successfully update.", id));
        return "redirect:/admin/category";
    }

}
