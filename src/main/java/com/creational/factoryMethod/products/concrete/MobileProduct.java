package com.creational.factoryMethod.products.concrete;

import com.creational.factoryMethod.products.Product;

public class MobileProduct implements Product {

	@Override
	public void create() {
		System.out.println("Creating Mobile Product.");
	}
}
