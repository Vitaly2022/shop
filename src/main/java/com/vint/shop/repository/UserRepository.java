package com.vint.shop.repository;

import com.vint.shop.domain.Role;
import com.vint.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);
    User findByLogin (String login);
    User findByUsername (String username);





}
