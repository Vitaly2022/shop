package com.vint.shop.controllers;

import com.vint.shop.domain.User;
import com.vint.shop.repository.OrderProductMapRepository;
import com.vint.shop.repository.OrderRepository;
import com.vint.shop.repository.UserRepository;
import com.vint.shop.service.impl.OrderServiceImpl;
import com.vint.shop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private OrderProductMapRepository orderProductMapRepository;


    @GetMapping
    public String adminhome() {

        return "admin/admin";
    }

    @GetMapping("/editusers")
    public String userList(Model model) {
        model.addAttribute("allUsers", userDetailsServiceImpl.findAll());
        model.addAttribute("roleUsers", userDetailsServiceImpl.findAll());

        return "admin/editusers";
    }

    @GetMapping("/editusers/{id}")
    public String userid(@PathVariable("id") Long id, Model model) {
        User usercard = userRepository.findById(id).get();
        model.addAttribute("usercard", usercard);
        //    System.out.println(userRepository.findById(id));
        return "admin/usercard";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDetailsServiceImpl.deleteUser(id);
        return "redirect:/admin/editusers";
    }

    @GetMapping("/orders")
    public String ordersUsers(Model model) {
        System.out.println(orderRepository.findAll());
        model.addAttribute("AllOrders", orderRepository.findAll());

        return "admin/adminorders/adminordersuser";
    }

    @GetMapping("/orders/view/{id}")
    public String orderid(@PathVariable("id") Long id, Model model) {
        model.addAttribute("OrdersProducts", orderProductMapRepository.findAllByOrderid(id));

        return "admin/adminorders//productoforder";
    }


}