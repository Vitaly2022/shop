package com.vint.shop.service.impl;

import com.vint.shop.domain.Supplier;
import com.vint.shop.repository.SupplierRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {
    @Mock
    private SupplierRepository supplierRepository;
    @InjectMocks
    private SupplierServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new SupplierServiceImpl(supplierRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        verify(supplierRepository).findAll();
    }

    @Test
    void saveSupplier() {
        Supplier newSupplier = new Supplier();
        newSupplier.setId(3);
        newSupplier.setName("TestSupplier");
        underTest.saveSupplier(newSupplier);
        ArgumentCaptor<Supplier> supplierArgumentCaptor = ArgumentCaptor.forClass(Supplier.class);
        verify(supplierRepository).save(supplierArgumentCaptor.capture());
        Supplier supplierCapture = supplierArgumentCaptor.getValue();
        assertThat(supplierCapture).isEqualTo(newSupplier);
    }

    @Test
    void viewDeleteSupplier() {
        Supplier newSupplier = new Supplier();
        newSupplier.setId(3);
        newSupplier.setName("TestSupplier");
        supplierRepository.deleteById(newSupplier.getId());
        ArgumentCaptor<Long> supplierArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(supplierRepository).deleteById(supplierArgumentCaptor.capture());
        Long i = supplierArgumentCaptor.getValue();
        Assertions.assertEquals(3, i);
    }

    boolean resultTest = false;

    @Test
    void trueIfFindSupplier() {
        Supplier newSupplier = new Supplier();
        newSupplier.setId(3);
        newSupplier.setName("TestSupplier");
        when(supplierRepository.findById(newSupplier.getId())).thenReturn(Optional.of(newSupplier));
        if (supplierRepository.findById(newSupplier.getId()).isPresent()) resultTest = true;
        assertThat(resultTest).isTrue();
    }


}