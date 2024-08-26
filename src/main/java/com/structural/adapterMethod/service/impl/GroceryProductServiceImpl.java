package com.structural.adapterMethod.service.impl;

import org.springframework.stereotype.Service;

import com.structural.adapterMethod.service.GroceryProductService;

@Service
public class GroceryProductServiceImpl implements GroceryProductService {
    @Override
    public void addGroceryProduct(String name) {
        System.out.println("Adding grocery product: " + name);
    }

    @Override
    public String getGroceryProduct(String id) {
        return "Grocery product details for ID " + id;
    }
}
