package com.vint.shop.repository;

import com.vint.shop.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository <Roles, Integer> {
}
