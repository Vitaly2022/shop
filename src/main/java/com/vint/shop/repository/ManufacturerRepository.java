package com.vint.shop.repository;

import com.vint.shop.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name);
}
