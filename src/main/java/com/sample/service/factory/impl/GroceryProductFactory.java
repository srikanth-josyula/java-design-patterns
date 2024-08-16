package com.sample.service.factory.impl;

import com.sample.model.products.Products;
import com.sample.model.products.impl.Pantry;
import com.sample.model.products.impl.Produce;
import com.sample.service.factory.ProductFactory;

//Concrete Factory Classes
public class GroceryProductFactory implements ProductFactory {

    @Override
    public Products createProduct(String productType) {
        if (productType.equalsIgnoreCase("Produce")) {
            return new Produce();
        } else if (productType.equalsIgnoreCase("Pantry")) {
            return new Pantry();
        }
        throw new IllegalArgumentException("Unknown product type: " + productType);
    }
}
