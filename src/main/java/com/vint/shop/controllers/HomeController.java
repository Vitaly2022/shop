package com.vint.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

@GetMapping ("/")
public String index () {

    return  "index";
 }

@GetMapping("/news")
public String news() {

    return "news";
 }
}
