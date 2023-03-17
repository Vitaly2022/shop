package com.vint.shop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllersTest {

    @Autowired
    AdminController adminController;

    @Autowired
    CartController cartController;

    @Autowired
    CategoryController categoryController;

    @Autowired
    HomeController homeController;

    @Autowired
    ManufacturerController manufacturerController;

    @Autowired
    OrderController orderController;

    @Autowired
    ProductController productController;

    @Autowired
    RegistrationController registrationController;

    @Autowired
    ReviewController reviewController;

    @Autowired
    SupplierController supplierController;

    @Autowired
    UserController userController;

    @Test
    public void checkIfAdminControllerNotNull() throws Exception {
        assertThat(adminController).isNotNull();
    }

    @Test
    public void checkIfCartControllerNotNull() throws Exception {
        assertThat(cartController).isNotNull();
    }

    @Test
    public void checkIfCategoryControllerNotNull() throws Exception {
        assertThat(categoryController).isNotNull();
    }

    @Test
    public void checkIfHomeControllerNotNull() throws Exception {
        assertThat(homeController).isNotNull();
    }

    @Test
    public void checkIfManufacturerControllerNotNull() throws Exception {
        assertThat(manufacturerController).isNotNull();
    }

    @Test
    public void checkIfOrderControllerNotNull() throws Exception {
        assertThat(orderController).isNotNull();
    }

    @Test
    public void checkIfProductControllerNotNull() throws Exception {
        assertThat(productController).isNotNull();
    }

    @Test
    public void checkIfRegistrationControllerNotNull() throws Exception {
        assertThat(registrationController).isNotNull();
    }

    @Test
    public void checkIfReviewControllerNotNull() throws Exception {
        assertThat(reviewController).isNotNull();
    }

    @Test
    public void checkIfSupplierControllerNotNull() throws Exception {
        assertThat(supplierController).isNotNull();
    }

    @Test
    public void checkIfUserControllerNotNull() throws Exception {
        assertThat(userController).isNotNull();
    }
}
