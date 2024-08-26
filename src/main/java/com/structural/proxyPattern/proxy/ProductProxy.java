package com.structural.proxyPattern.proxy;

import com.structural.proxyPattern.service.Product;
import com.structural.proxyPattern.service.impl.ElectronicProduct;
import com.structural.proxyPattern.service.impl.GroceryProduct;

public class ProductProxy implements Product {
	private Product realProduct;
	private String type;

	public ProductProxy(String type) {
		this.type = type;
	}

	@Override
	public void produce() {
		if (realProduct == null) {
			createProduct();
		}
		logAccess();
		realProduct.produce();
	}

	private void createProduct() {
		System.out.println("Creating product of type: " + type);
		if ("electronic".equalsIgnoreCase(type)) {
			realProduct = new ElectronicProduct();
		} else if ("grocery".equalsIgnoreCase(type)) {
			realProduct = new GroceryProduct();
		} else {
			throw new IllegalArgumentException("Unknown product type");
		}
	}

	private void logAccess() {
		System.out.println("Logging access to product of type: " + type);
	}

}
