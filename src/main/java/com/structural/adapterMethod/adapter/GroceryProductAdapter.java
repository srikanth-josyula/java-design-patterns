package com.structural.adapterMethod.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.structural.adapterMethod.service.GroceryProductService;
import com.structural.adapterMethod.service.ProductService;

@Service
public class GroceryProductAdapter implements ProductService {
    private final GroceryProductService groceryProductService;

    @Autowired
    public GroceryProductAdapter(GroceryProductService groceryProductService) {
        this.groceryProductService = groceryProductService;
    }

    @Override
    public void addProduct(String name) {
        groceryProductService.addGroceryProduct(name);
    }

    @Override
    public String getProduct(String id) {
        return groceryProductService.getGroceryProduct(id);
    }
}
