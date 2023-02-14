package com.vint.shop.controllers;

import com.vint.shop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping ("/admin")
    public String adminhome () {

        return "admin";
    }

    @GetMapping("/admin/editusers")
    public String userList(Model model) {
        model.addAttribute("allUsers", userDetailsServiceImpl.findAll());
        model.addAttribute("roleUsers", userDetailsServiceImpl.findAll());

        return "editusers";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDetailsServiceImpl.deleteUser(id);
        return "redirect:/admin/editusers";
    }

//    @PostMapping("/admin/editusers")
//    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
//                              @RequestParam(required = true, defaultValue = "" ) String actionn,
//                              Model model) {
//        if (actionn.equals("delete")){
//            userDetailsServiceImpl.deleteUser(userId);
//        }
//        return "editusers";
//        }




}