package com.creational.abstractFactory.factory;

import com.creational.abstractFactory.products.Product;

//Abstract Factory Interface
public interface ProductFactory {
    Product createProduct(String type);
}