package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.ProductItem;

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

	public Map<String, String> putProduct(ProductItem product) {
		// Assume DB connection is happening
		productCache.put(product.getId(), product.getName());
		return productCache;
	}
}
