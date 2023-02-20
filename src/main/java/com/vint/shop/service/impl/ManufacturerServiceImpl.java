package com.vint.shop.service.impl;

import com.vint.shop.domain.Manufacturer;
import com.vint.shop.repository.ManufacturerRepository;
import com.vint.shop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    protected ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public boolean saveManufacturer(Manufacturer manufacturer) {
        Manufacturer manufacturerFromDB = manufacturerRepository.findByName(manufacturer.getName());

        if (manufacturerFromDB != null) {
            return false;
        }
        manufacturerRepository.save(manufacturer);
        return true;
    }

    @Override
    public boolean deleteManufacturer(Long manufacturerId) {
        if (manufacturerRepository.findById(manufacturerId).isPresent()) {
            manufacturerRepository.deleteById(manufacturerId);
            return true;
        }
        return false;
    }

}