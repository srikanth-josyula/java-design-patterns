package com.structural.bridgePattern.abstraction;

import com.structural.bridgePattern.implementation.ProductType;

//Product.java (Abstraction)
public abstract class Product {
	protected ProductType productType;

	protected Product(ProductType productType) {
		this.productType = productType;
	}

	public abstract void produce();
}
