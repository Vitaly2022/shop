package com.vint.shop.repository;

import com.vint.shop.domain.Manufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ManufacturerRepositoryTest {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    void OkIffindManufacturerByName() {

        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(5);
        newManufacturer.setName("TestManufacturer");
        manufacturerRepository.save(newManufacturer);
        Manufacturer result = manufacturerRepository.findByName(newManufacturer.getName());
        Assertions.assertEquals("TestManufacturer", result.getName());

    }
}