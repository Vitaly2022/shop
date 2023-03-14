package com.vint.shop.repository;

import com.vint.shop.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void OkIffindUserByEmail() {
        User user = createUser();
        userRepository.save(user);
        User result = userRepository.findByEmail(user.getEmail());
        Assertions.assertEquals("asd@cmail.com", result.getEmail());

    }

    @Test
    void OkIffindByLogin() {
        User user = createUser();
        userRepository.save(user);
        User result = userRepository.findByLogin(user.getLogin());
        Assertions.assertEquals("test123456", result.getLogin());
    }

    @Test
    void OkIffindByUsername() {
        User user = createUser();
        userRepository.save(user);
        User result = userRepository.findByUsername(user.getUsername());
        Assertions.assertEquals("Eva", result.getUsername());
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