package com.vint.shop.repository;

import com.vint.shop.domain.Role;
import com.vint.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Long> {
    //User findUserById(long id);
    User findByEmail(String email);
    User findByLogin (String login);
    User findUserByUsername (String username);




}
