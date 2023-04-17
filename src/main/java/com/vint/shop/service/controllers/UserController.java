package com.vint.shop.service.controllers;

import com.vint.shop.domain.User;
import com.vint.shop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserDetailsServiceImpl userDetailsServiceImpl;


    @GetMapping
    public String userhome(Model model) {
        return "user/userhome";
    }

    @GetMapping("/update")
    public String editProduct(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userUpdate", user);

        return "user/updateprofile";

    }

    @PostMapping("/update")
    @Transactional
    public String updateProduct(@ModelAttribute("userUpdate") User user) {

        Long id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        userDetailsServiceImpl.updateUser(id, user);

        return "redirect:/user";
    }
}
