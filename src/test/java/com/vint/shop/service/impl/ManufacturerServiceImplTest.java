package com.vint.shop.service.impl;

import com.vint.shop.domain.Manufacturer;
import com.vint.shop.repository.ManufacturerRepository;
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
class ManufacturerServiceImplTest {

    @Mock
    private ManufacturerRepository manufacturerRepository;

    @InjectMocks
    private ManufacturerServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new ManufacturerServiceImpl(manufacturerRepository);
    }

    @Test
    void findAll() {
        underTest.findAll();
        verify(manufacturerRepository).findAll();
    }

    @Test
    void saveManufacturer() {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(5);
        newManufacturer.setName("TestManufacturer");
        underTest.saveManufacturer(newManufacturer);
        ArgumentCaptor<Manufacturer> manufacturerArgumentCaptor = ArgumentCaptor.forClass(Manufacturer.class);
        verify(manufacturerRepository).save(manufacturerArgumentCaptor.capture());
        Manufacturer manufacturerCapture = manufacturerArgumentCaptor.getValue();
        assertThat(manufacturerCapture).isEqualTo(newManufacturer);
    }

    @Test
    void deleteManufacturer() {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(5);
        newManufacturer.setName("TestManufacturer");
        manufacturerRepository.deleteById(newManufacturer.getId());
        ArgumentCaptor<Long> manufacturerArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(manufacturerRepository).deleteById(manufacturerArgumentCaptor.capture());
        Long i = manufacturerArgumentCaptor.getValue();
        Assertions.assertEquals(5, i);
    }

    boolean resultTest = false;

    @Test
    void TrueIfFindManufacturer() {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(5);
        newManufacturer.setName("TestManufacturer");
        when(manufacturerRepository.findById(newManufacturer.getId())).thenReturn(Optional.of(newManufacturer));
        if (manufacturerRepository.findById(newManufacturer.getId()).isPresent()) resultTest = true;
        assertThat(resultTest).isTrue();
    }
}