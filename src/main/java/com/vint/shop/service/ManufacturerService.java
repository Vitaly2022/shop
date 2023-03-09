package com.vint.shop.service;

import com.vint.shop.domain.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> findAll();

    boolean deleteManufacturer(Long id);

    boolean saveManufacturer(Manufacturer id);

}
