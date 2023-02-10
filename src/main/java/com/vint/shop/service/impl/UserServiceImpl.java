package com.vint.shop.service.impl;

import com.vint.shop.domain.User;
import com.vint.shop.repository.UserRepository;
import com.vint.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

}
