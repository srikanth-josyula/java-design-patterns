package com.creational.factoryMethod.products.concrete;

import com.creational.factoryMethod.products.Product;

public class LaptopProduct implements Product {

	@Override
	public void create() {
		System.out.println("Creating Laptop Product.");
	}
}
