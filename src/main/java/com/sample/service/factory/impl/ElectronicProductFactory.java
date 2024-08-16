package com.sample.service.factory.impl;

import com.sample.model.products.Products;
import com.sample.model.products.impl.Laptop;
import com.sample.model.products.impl.Mobile;
import com.sample.service.factory.ProductFactory;

//Concrete Factory Classes
public class ElectronicProductFactory implements ProductFactory {

    @Override
    public Products createProduct(String productType) {
        if (productType.equalsIgnoreCase("Mobile")) {
            return new Mobile();
        } else if (productType.equalsIgnoreCase("Laptop")) {
            return new Laptop();
        }
        throw new IllegalArgumentException("Unknown product type: " + productType);
    }
}
