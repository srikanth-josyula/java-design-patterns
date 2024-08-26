package com.creational.factoryMethod.factory.impl;

import com.creational.factoryMethod.factory.ProductFactory;
import com.creational.factoryMethod.products.Product;
import com.creational.factoryMethod.products.concrete.LaptopProduct;
import com.creational.factoryMethod.products.concrete.MobileProduct;
import com.creational.factoryMethod.products.concrete.PantryProduct;
import com.creational.factoryMethod.products.concrete.ProduceProduct;

public class ConcreteProductFactory implements ProductFactory {

	@Override
	public Product createProduct(String type) {
		switch (type.toLowerCase()) {
		case "laptop":
			return new LaptopProduct();
		case "mobile":
			return new MobileProduct();
		case "pantry":
			return new PantryProduct();
		case "produce":
			return new ProduceProduct();
		default:
			throw new IllegalArgumentException("Unknown product type: " + type);
		}
	}
}
