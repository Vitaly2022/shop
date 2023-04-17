package com.vint.shop.service.impl;

import com.vint.shop.domain.Supplier;
import com.vint.shop.repository.SupplierRepository;
import com.vint.shop.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    protected SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Transactional
    @Override
    public boolean saveSupplier(Supplier supplier) {
        Supplier supplierFromDB = supplierRepository.findByName(supplier.getName());

        if (supplierFromDB != null) {
            return false;
        }
        supplierRepository.save(supplier);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteSupplier(Long supplierId) {
        if (supplierRepository.findById(supplierId).isPresent()) {
            supplierRepository.deleteById(supplierId);
            return true;
        }
        return false;
    }

}
