package com.vint.shop.controllers;

import com.vint.shop.domain.Category;
import com.vint.shop.domain.Manufacturer;
import com.vint.shop.repository.ManufacturerRepository;
import com.vint.shop.service.impl.ManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/manufacturer")
public class ManufacturerController {

    @Autowired
    protected ManufacturerServiceImpl manufacturerServiceImpl;

    @Autowired
    protected ManufacturerRepository manufacturerRepository;

    @GetMapping
    public String viewCategory (Model model) {
        model.addAttribute("allmanufacturers", manufacturerServiceImpl.findAll());
        model.addAttribute("newManufacturerForm", new Manufacturer());
        return "admin/manufacturer/manufacturer";
    }
    @PostMapping
    public String newCategory(@ModelAttribute("newManufacturerForm") Manufacturer newManufacturerForm, Model model) {

        if (!manufacturerServiceImpl.saveManufacturer(newManufacturerForm)){
            model.addAttribute("manufacturernameError", "This name is taken");
            return "admin/manufacturer";
        }
        return "redirect:/admin/manufacturer";

    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        manufacturerServiceImpl.deleteManufacturer(id);
        return "redirect:/admin/manufacturer";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") long id, Model model) {
        if(!manufacturerRepository.existsById(id)) {
            return "redirect:admin/manufacturer";
        }
        Manufacturer manufacturer = manufacturerRepository.findById(id).get();
        ArrayList<Manufacturer> editManufacturer = new ArrayList<>();
        editManufacturer.add(manufacturer);
        model.addAttribute("editManufacturer", editManufacturer);
        return "admin/manufacturer/editmanufacturer";
    }

    @PostMapping("/edit/{id}")
    @Transactional
    public String updateCategory(@PathVariable("id") long id, @RequestParam String name, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).get();
        manufacturer.setName(name);
        manufacturerRepository.save(manufacturer);
        return "redirect:/admin/manufacturer";
    }




}
