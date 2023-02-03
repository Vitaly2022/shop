package com.vint.shop.service.impl;

import com.vint.shop.domain.Users;
import com.vint.shop.repository.UsersRepository;
import com.vint.shop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users findUsersById(int id) {
        return usersRepository.findUsersById(id);
    }
}
