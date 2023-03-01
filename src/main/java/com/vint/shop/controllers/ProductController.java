package com.vint.shop.controllers;

import com.vint.shop.domain.Product;
import com.vint.shop.repository.ProductRepository;
import com.vint.shop.service.impl.CategoryServiceImpl;
import com.vint.shop.service.impl.ManufacturerServiceImpl;
import com.vint.shop.service.impl.ProductServiceImpl;
import com.vint.shop.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    protected ProductServiceImpl productServiceImpl;

    @Autowired
    protected CategoryServiceImpl categoryServiceImpl;

    @Autowired
    protected ManufacturerServiceImpl manufacturerServiceImpl;

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected SupplierServiceImpl supplierServiceImpl;

    @GetMapping
    public String viewProducts(Model model) {
        model.addAttribute("allproducts", productServiceImpl.findAll());
        return "admin/product/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("newProductForm", new Product());
        model.addAttribute("categories", categoryServiceImpl.findAll());
        model.addAttribute("manufacturer", manufacturerServiceImpl.findAll());
        model.addAttribute("supplier", supplierServiceImpl.findAll());

        return "admin/product/newproduct";
    }

    @PostMapping("/new")
    public String createNewProduct(@ModelAttribute("newProductForm") Product newProductForm, Model model) {
        System.out.println("New product=" + newProductForm);
        if (!productServiceImpl.saveProduct(newProductForm)) {
            model.addAttribute("productNameError", "This name is taken");
            return "admin/product/newproduct";
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        productServiceImpl.deleteProduct(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model) {
        if (!productRepository.existsById(id)) {
            return "redirect:admin/product";
        }
        model.addAttribute("editProduct", productRepository.findById(id).get());
        model.addAttribute("categories", categoryServiceImpl.findAll());
        model.addAttribute("manufacturer", manufacturerServiceImpl.findAll());
        model.addAttribute("supplier", supplierServiceImpl.findAll());

        return "admin/product/editproduct";
    }

    @PostMapping("/edit/{id}")
    @Transactional
    public String updateProduct(@PathVariable("id") long id, @ModelAttribute("editProduct") Product editProduct) {

        productServiceImpl.updateProduct(id, editProduct);
        return "redirect:/admin/product";
    }

}
