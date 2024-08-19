package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.ProductItem;

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

	public Map<String, String> putProduct(ProductItem product) {
		// Assume DB connection is happening
		productCache.put(product.getId(), product.getName());
		return productCache;
	}
}
