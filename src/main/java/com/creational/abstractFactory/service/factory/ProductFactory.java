package com.creational.abstractFactory.service.factory;

import com.creational.abstractFactory.model.products.Products;

//Abstract Factory Interface
public interface ProductFactory {
    Products createProduct(String productType);
}
