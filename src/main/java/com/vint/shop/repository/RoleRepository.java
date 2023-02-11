package com.vint.shop.repository;

import com.vint.shop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
//    Role findRoleByName(String role);
//    String findRoleById(int id);
}
