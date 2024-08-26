package com.structural.adapterMethod.service.impl;

import org.springframework.stereotype.Service;

import com.structural.adapterMethod.service.ElectronicProductService;

@Service
public class ElectronicsProductServiceImpl implements ElectronicProductService {
    @Override
    public void addElectronicProduct(String name) {
        System.out.println("Adding electronic product: " + name);
    }

    @Override
    public String getElectronicProduct(String id) {
        return "Electronic product details for ID " + id;
    }
}

