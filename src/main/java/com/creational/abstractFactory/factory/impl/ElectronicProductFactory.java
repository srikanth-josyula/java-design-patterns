package com.creational.abstractFactory.factory.impl;

import com.creational.abstractFactory.factory.ProductFactory;
import com.creational.abstractFactory.model.products.Products;
import com.creational.abstractFactory.model.products.impl.Laptop;
import com.creational.abstractFactory.model.products.impl.Mobile;

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
