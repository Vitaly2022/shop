package com.vint.shop.controllers;

import com.vint.shop.domain.Order;
import com.vint.shop.domain.User;
import com.vint.shop.repository.OrderProductMapRepository;
import com.vint.shop.repository.OrderRepository;
import com.vint.shop.repository.UserRepository;
import com.vint.shop.service.controllers.AdminController;
import com.vint.shop.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class AdminControllerTest {

    private MockMvc mockMvc;
    @Mock
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderProductMapRepository orderProductMapRepository;

    @BeforeEach
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(
                        new AdminController(userDetailsServiceImpl, userRepository, orderRepository, orderProductMapRepository))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void AdminControllerStatus1() throws Exception {
        this.mockMvc.perform(get("/admin")).andExpect(status().isOk())
                .andExpect(view().name("admin/admin")).andDo(print());
    }

    @Test
    public void AdminControllerStatus2() throws Exception {
        this.mockMvc.perform(get("/admin/editusers")).andExpect(status().isOk())
                .andExpect(view().name("admin/editusers")).andDo(print());
    }

    @Test
    public void AdminControllerStatus3() throws Exception {
        User testUser = new User();
        testUser.setId(1);
        long id = testUser.getId();
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(testUser));
        User user = userRepository.findById(id).get();
        this.mockMvc.perform(get("/admin/editusers/" + id))
                .andExpect(view().name("admin/usercard")).andDo(print());
    }

    @Test
    public void AdminControllerStatus4() throws Exception {
        User testUser = new User();
        long id = testUser.getId();
        this.mockMvc.perform(get("/admin/user/delete/" + id))
                .andExpect(redirectedUrl("/admin/editusers"));
    }

    @Test
    public void AdminControllerStatus5() throws Exception {
        this.mockMvc.perform(get("/admin/orders")).andExpect(status().isOk())
                .andExpect(view().name("admin/adminorders/adminordersuser")).andDo(print());
    }

    @Test
    public void AdminControllerStatus6() throws Exception {
        Order testOrder = new Order();
        testOrder.setId(1);
        long id = testOrder.getId();
        this.mockMvc.perform(get("/admin/orders/view/" + id)).andExpect(status().isOk())
                .andExpect(view().name("admin/adminorders//productoforder")).andDo(print());
    }
}