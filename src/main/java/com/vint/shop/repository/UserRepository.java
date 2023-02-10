package com.vint.shop.repository;

import com.vint.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer> {
    User findUserById(int id);
    User findByUsername(String username);

    User findByEmail(String email);



}
