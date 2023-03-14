package com.vint.shop.repository;

import com.vint.shop.domain.Product;
import com.vint.shop.domain.Review;
import com.vint.shop.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  ReviewRepository reviewRepository;

    //Review findByTitle(String title);

    @Test
    void OkIffindByTitle() {
        User user = createUser();
        userRepository.save(user);

        Product product = new Product();
        productRepository.save(product);

        Review newReview = new Review();
        newReview.setTitle("TestReview");
        newReview.setProduct(product);
        newReview.setUser(user);
        reviewRepository.save(newReview);

        Review result = reviewRepository.findByTitle("TestReview");
        Assertions.assertThat(result).isNotNull();
        assertEquals("TestReview",result.getTitle());

    }

    private User createUser() {
        User newUser = new User();
        newUser.setId(1);
        newUser.setEmail("asd@gmail.com");
        newUser.setUsername("Eva");
        newUser.setLogin("test123456");
        newUser.setPassword("Nfywq21@$55");
        return newUser;
    }
}