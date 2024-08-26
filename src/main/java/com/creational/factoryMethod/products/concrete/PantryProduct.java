package com.creational.factoryMethod.products.concrete;

import com.creational.factoryMethod.products.Product;

public class PantryProduct implements Product {

	@Override
	public void create() {
		System.out.println("Creating Pantry Product.");
	}
}
