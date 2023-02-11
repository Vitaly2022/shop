package com.vint.shop.service;
import com.vint.shop.domain.Role;
import com.vint.shop.domain.User;

public interface UserService {

    User save(User user);
    User findByEmail(String email);
    //User findById(long id);
   // User findByLogin (String login);

    User findUserByUsername (String username);
}
