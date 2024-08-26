package com.structural.bridgePattern.implementation.impl;

import com.structural.bridgePattern.implementation.ProductType;

//GroceryProductType.java (Concrete Implementor)
public class GroceryProductType implements ProductType {
	@Override
	public void createProduct() {
		System.out.println("Creating an Grocery Product.");
	}
}
