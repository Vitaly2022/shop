package com.vint.shop.domain.service;

import com.vint.shop.domain.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    boolean deleteSupplier(Long id);

    boolean saveSupplier(Supplier id);
}
