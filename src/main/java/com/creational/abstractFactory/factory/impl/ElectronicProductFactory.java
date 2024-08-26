package com.creational.abstractFactory.factory.impl;

import com.creational.abstractFactory.factory.ProductFactory;
import com.creational.abstractFactory.products.Product;
import com.creational.abstractFactory.products.concrete.electronics.LaptopProduct;
import com.creational.abstractFactory.products.concrete.electronics.MobileProduct;

public class ElectronicProductFactory implements ProductFactory {
    
    @Override
    public Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "laptop":
                return new LaptopProduct();
            case "mobile":
                return new MobileProduct();
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}
