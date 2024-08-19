package com.creational.prototype.service;

import org.springframework.stereotype.Service;

import com.creational.prototype.model.ProductItem;


@Service
public class ProductServicePrototype {

	public ProductItem createShallowCopy(ProductItem product) throws CloneNotSupportedException {
		return product.clone(); // Shallow copy
	}

	public ProductItem createDeepCopy(ProductItem product) {
		return product.deepClone(); // Deep copy
	}
}
