package com.vint.shop.controllers;

import com.vint.shop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControllers {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/admin")
    public String home() {
        System.out.println(usersRepository.findUsersById(1));

        return "admin";
    }
}
