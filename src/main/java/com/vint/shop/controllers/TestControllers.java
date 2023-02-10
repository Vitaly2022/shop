package com.vint.shop.controllers;

import com.vint.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControllers {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/admin")
    public String home() {
        System.out.println(userRepository.findUserById(1));

        return "admin";
    }
}
