package com.vint.shop.controllers;

import com.vint.shop.domain.Manufacturer;
import com.vint.shop.repository.ManufacturerRepository;
import com.vint.shop.service.impl.ManufacturerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class ManufacturerControllerTest {

    private MockMvc mockMvc;
    @Mock
    private ManufacturerServiceImpl manufacturerServiceIml;

    @Mock
    private ManufacturerRepository manufacturerRepository;

    @BeforeEach
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(new ManufacturerController(manufacturerServiceIml, manufacturerRepository))
                .setViewResolvers(viewResolver)
                .build();
    }


    @Test
    public void ManufacturerControllerStatus1() throws Exception {
        this.mockMvc.perform(get("/admin/manufacturer")).andExpect(status().isOk())
                .andExpect(view().name("admin/manufacturer/manufacturer")).andDo(print());
    }

    @Test
    public void ManufacturerControllerPostStatus2() throws Exception {
        this.mockMvc.perform(post("/admin/manufacturer")).andExpect(status().isOk());
        Manufacturer newManufacturerForm = new Manufacturer();
        Mockito.when(manufacturerServiceIml.saveManufacturer(newManufacturerForm)).thenReturn(false);
        if (!manufacturerServiceIml.saveManufacturer(newManufacturerForm))
            this.mockMvc.perform(post("/admin/manufacturer"))
                    .andExpect(view().name("admin/manufacturer")).andDo(print());
        else this.mockMvc.perform(post("/admin/manufacturer"))
                .andExpect(redirectedUrl("/admin/manufacturer")).andDo(print());
    }

    @Test
    public void ManufacturerControllerStatus3() throws Exception {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(1);
        long id = newManufacturer.getId();
        this.mockMvc.perform(get("/admin/manufacturer//delete/" + id)).andExpect(status().is3xxRedirection());
    }

    @Test
    public void ManufacturerControllerEditStatus4() throws Exception {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(1);
        long id = newManufacturer.getId();
        Mockito.when(manufacturerRepository.existsById(id)).thenReturn(true);
        if (!manufacturerRepository.existsById(id)) {
            this.mockMvc.perform(get("/admin/manufacturer/edit/" + id)).andExpect(status().is3xxRedirection());
        }
        Mockito.when(manufacturerRepository.findById(id)).thenReturn(Optional.of(newManufacturer));
        this.mockMvc.perform(get("/admin/manufacturer/edit/" + id))
                .andExpect(view().name("admin/manufacturer/editmanufacturer")).andDo(print());
    }

    @Test
    public void ManufacturerControllerEditStatus5() throws Exception {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(1);
        long id = newManufacturer.getId();
        Mockito.when(manufacturerRepository.findById(id)).thenReturn(Optional.of(newManufacturer));
        Manufacturer testManufacturer = manufacturerRepository.findById(id).get();
        manufacturerRepository.save(testManufacturer);
        this.mockMvc.perform(post("/admin/manufacturer/edit/" + id).param("name", "TestName"))
                .andExpect(redirectedUrl("/admin/manufacturer")).andDo(print());
    }

}