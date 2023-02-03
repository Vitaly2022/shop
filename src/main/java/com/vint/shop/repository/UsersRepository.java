package com.vint.shop.repository;

import com.vint.shop.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository <Users, Integer> {
    Users findUsersById(int id);
}
