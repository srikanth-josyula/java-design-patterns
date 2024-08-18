package com.creational.singletonMethod.cache;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.ProductItem;

// Singleton class
public class ProductDBEntry {

	private static ProductDBEntry instance;
	private Map<String, String> productCache = new HashMap<>();

	private ProductDBEntry() {
		System.out.println("ProductDBEntry instance created.");
	}

	public static synchronized ProductDBEntry getInstance() {
		if (instance == null) {
			instance = new ProductDBEntry();
		}
		return instance;
	}

	public Map<String, String> putProduct(ProductItem product) {
		// Assume DB connection is happening
		productCache.put(product.getId(), product.getName());
		return productCache;
	}
}
