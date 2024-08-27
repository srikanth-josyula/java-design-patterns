package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.Product;

// Singleton class
public class EagerSingletonProductDBEntry {
	private Map<String, String> productCache = new HashMap<>();

	/**
	 * This way of creating Singleton class with final keyword is a naive way, not
	 * useful
	 **/
	public static EagerSingletonProductDBEntry INSTANCE = new EagerSingletonProductDBEntry();

	private EagerSingletonProductDBEntry() {
	}

	public static EagerSingletonProductDBEntry getInstance() {
		return INSTANCE;
	}

	public Map<String, String> putProduct(Product product) {
		// Store product in cache using its category as the key
		productCache.put(product.getCategory(), product.getType());

		// Prepare and return detailed information
		Map<String, String> productInfo = new HashMap<>();
		productInfo.put("category", product.getCategory());
		productInfo.put("type", product.getType());
		productInfo.put("className", product.getClass().getSimpleName());
		productInfo.put("hashCode", Integer.toHexString(product.hashCode()));

		return productInfo;
	}
}
