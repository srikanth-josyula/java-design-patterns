package com.creational.abstractFactory.service.factory.impl;

import com.creational.abstractFactory.model.products.Products;
import com.creational.abstractFactory.model.products.impl.Laptop;
import com.creational.abstractFactory.model.products.impl.Mobile;
import com.creational.abstractFactory.service.factory.ProductFactory;

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
