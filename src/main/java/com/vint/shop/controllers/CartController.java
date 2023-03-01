package com.vint.shop.controllers;

import com.vint.shop.domain.Product;
import com.vint.shop.repository.OrderProductMapRepository;
import com.vint.shop.repository.OrderRepository;
import com.vint.shop.repository.ProductRepository;
import com.vint.shop.repository.UserRepository;
import com.vint.shop.service.impl.OrderServiceImpl;
import com.vint.shop.service.impl.ShoppingCartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    protected ShoppingCartServiceImpl shoppingCartServiceImpl;

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected OrderProductMapRepository orderProductMapRepository;

    @Autowired
    protected OrderServiceImpl orderServiceImpl;

    @Autowired
    protected UserRepository userRepository;


    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", shoppingCartServiceImpl.productsInCart());
        model.addAttribute("totalPrice", shoppingCartServiceImpl.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).get();
        if (product != null) {
            shoppingCartServiceImpl.addProduct(product);
            logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        }
        return "redirect:/index";
    }

    @GetMapping("/cartfromcateg/add/{id}")
    public String addProdToCart(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).get();
        if (product != null) {
            shoppingCartServiceImpl.addProduct(product);
            logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        }
        String red = "redirect:/searchByCategory/" + product.getCategory().getId();
        System.out.println(red);
        return red;
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).get();

        if (product != null) {
            shoppingCartServiceImpl.removeProduct(product);
            logger.debug(String.format("Product with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearProductsInCart() {
        shoppingCartServiceImpl.clearProducts();

        return "redirect:/cart";
    }

}
