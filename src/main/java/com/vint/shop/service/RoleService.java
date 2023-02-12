package com.vint.shop.service;
import com.vint.shop.domain.Role;

public interface RoleService {
    Role findRoleByName(String role);

    String findRoleById(int id);
}
