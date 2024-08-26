package com.creational.factoryMethod.factory;

import com.creational.factoryMethod.products.Product;

//Abstract Factory Interface
public interface ProductFactory {
	Product createProduct(String type);
}