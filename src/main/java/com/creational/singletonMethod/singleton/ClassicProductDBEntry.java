package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.ProductItem;

// Singleton class
public class ClassicProductDBEntry {

	private Map<String, String> productCache = new HashMap<>();

	//Mandatory Format Start
	/**
	 * This demonstrates singleton pattern using Double Checked Locking or "classic"
	 * singleton. This is also a lazy initializing singleton. Although this
	 * implementation solves the multi-threading issue with lazy initialization
	 * using volatile and double check locking, the volatile keyword is guaranteed
	 * to work only after JVMs starting with version 1.5 and later.
	 **/
	private volatile static ClassicProductDBEntry INSTANCE;

	private ClassicProductDBEntry() {
		System.out.println("ProductDBEntry instance created.");
	}

	public static synchronized ClassicProductDBEntry getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ClassicProductDBEntry();
		}
		return INSTANCE;
	}
	//Mandatory Format End

	public Map<String, String> putProduct(ProductItem product) {
		// Assume DB connection is happening
		productCache.put(product.getId(), product.getName());
		return productCache;
	}

}
