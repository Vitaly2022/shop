package com.vint.shop.controllers;

import com.vint.shop.domain.Order;
import com.vint.shop.domain.OrderProductMap;
import com.vint.shop.domain.Product;
import com.vint.shop.domain.User;
import com.vint.shop.enumm.Status;
import com.vint.shop.repository.OrderProductMapRepository;
import com.vint.shop.repository.OrderRepository;
import com.vint.shop.repository.ProductRepository;
import com.vint.shop.service.impl.OrderServiceImpl;
import com.vint.shop.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Map;

import static com.vint.shop.enumm.Status.ACCEPTED;

@RequestMapping("/user")
@Controller
public class OrderController {
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

    public OrderController(ShoppingCartServiceImpl shoppingCartServiceImpl, ProductRepository productRepository, OrderRepository orderRepository, OrderProductMapRepository orderProductMapRepository, OrderServiceImpl orderServiceImpl) {
        this.shoppingCartServiceImpl = shoppingCartServiceImpl;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderProductMapRepository = orderProductMapRepository;
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("/carttoorder")
    public String carttoorder() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<Product, Integer> mapcart = shoppingCartServiceImpl.getCart();
        System.out.println("MAPA=" + mapcart);
        Order newOrder = new Order();
        Status newStatus = ACCEPTED;
        newOrder.setStatus(newStatus.toString());
        newOrder.setUser(user);
        newOrder.setGrand_total(shoppingCartServiceImpl.totalPrice());
        newOrder.setDateoforder(LocalDate.now());
        newOrder.setDescription("My order");
        System.out.println("NEWORDER=" + newOrder);
        orderServiceImpl.saveOrder(newOrder);
        System.out.println("OrderAfterSave=" + newOrder);

        for (Map.Entry<Product, Integer> entry : mapcart.entrySet()) {
            OrderProductMap orderProductMap = new OrderProductMap();
            System.out.println("ID =  " + entry.getKey() + " Значение = " + entry.getValue());
            orderProductMap.setOrder(newOrder);
            orderProductMap.setOrderid(newOrder.getId());
            orderProductMap.setProduct(entry.getKey());
            orderProductMap.setQuantity(entry.getValue());
            orderProductMap.setPrice(entry.getKey().getPrice());
            orderProductMapRepository.save(orderProductMap);
        }
        shoppingCartServiceImpl.clearProducts();
        return "redirect:/index";
    }


    @GetMapping("/orders")
    public String userList(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("MYORDER" + user + orderRepository.findById(user.getId()));
        model.addAttribute("OrdersUser", orderRepository.findByUser(user));

        return "order/ordersuser";
    }

    @GetMapping("/orders/view/{id}")
    public String userid(@PathVariable("id") Long id, Model model) {
        Order order = orderServiceImpl.findOrder(id).get();
        System.out.println("Order=" + order);
        model.addAttribute("OrdersProducts", orderProductMapRepository.findAllByOrderid(order.getId()));

        return "order/order";
    }

    @GetMapping("/delete/order/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        orderServiceImpl.deleteOrder(id);
        return "redirect:/user/orders";
    }


}

