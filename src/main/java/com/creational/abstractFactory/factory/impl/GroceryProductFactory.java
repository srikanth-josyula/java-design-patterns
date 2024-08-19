package com.creational.abstractFactory.factory.impl;

import com.creational.abstractFactory.factory.ProductFactory;
import com.creational.abstractFactory.model.products.Products;
import com.creational.abstractFactory.model.products.impl.Pantry;
import com.creational.abstractFactory.model.products.impl.Produce;

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
