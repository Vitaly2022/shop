package com.vint.shop.domain.service;

import com.vint.shop.domain.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);

    User findUserByUsername(String username);

}
