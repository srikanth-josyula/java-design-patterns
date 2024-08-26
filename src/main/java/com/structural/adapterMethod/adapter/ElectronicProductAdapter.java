package com.structural.adapterMethod.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.structural.adapterMethod.service.ElectronicProductService;
import com.structural.adapterMethod.service.ProductService;

@Service
public class ElectronicProductAdapter implements ProductService {
    private final ElectronicProductService electronicProductService;

    @Autowired
    public ElectronicProductAdapter(ElectronicProductService electronicProductService) {
        this.electronicProductService = electronicProductService;
    }

    @Override
    public void addProduct(String name) {
        electronicProductService.addElectronicProduct(name);
    }

    @Override
    public String getProduct(String id) {
        return electronicProductService.getElectronicProduct(id);
    }
}
