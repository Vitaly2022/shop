package com.vint.shop.repository;

import com.vint.shop.domain.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    void OkIffindSupplierByName() {

        Supplier newSupplier = new Supplier();
        newSupplier.setId(3);
        newSupplier.setName("TestSupplier");
        supplierRepository.save(newSupplier);
        Supplier result = supplierRepository.findByName(newSupplier.getName());
        Assertions.assertEquals("TestSupplier", result.getName());
    }
}