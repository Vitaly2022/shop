package com.vint.shop.repository;

import com.vint.shop.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository <Supplier, Integer> {
}
