package com.creational.abstractFactory.factory;

import com.creational.abstractFactory.model.products.Products;

//Abstract Factory Interface
public interface ProductFactory {
    Products createProduct(String productType);
}
