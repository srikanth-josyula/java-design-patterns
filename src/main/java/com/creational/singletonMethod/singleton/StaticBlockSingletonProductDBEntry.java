package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.Product;

// Singleton class
public class StaticBlockSingletonProductDBEntry {
	private Map<String, String> productCache = new HashMap<>();

	/**
	 * This way of creating Singleton class with static block leads to many resource
	 * wastage issues
	 **/
	public static StaticBlockSingletonProductDBEntry INSTANCE;

	private StaticBlockSingletonProductDBEntry() {
	}

	{
		// static block to initialize instance
		INSTANCE = new StaticBlockSingletonProductDBEntry();
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
