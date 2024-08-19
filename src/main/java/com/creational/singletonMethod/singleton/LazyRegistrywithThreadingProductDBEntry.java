package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;

import com.creational.singletonMethod.model.ProductItem;

// Singleton class
public class LazyRegistrywithThreadingProductDBEntry {
	private Map<String, String> productCache = new HashMap<>();

	
	private LazyRegistrywithThreadingProductDBEntry() {

	}

	// Use volatile to allow thread to get new value instead cached value

	private static volatile LazyRegistrywithThreadingProductDBEntry INSTANCE;
	private static LazyRegistrywithThreadingProductDBEntry NON_SYNC_INSTANCE;
	private static LazyRegistrywithThreadingProductDBEntry DBL_CHK_INSTANCE;

	// CASE 1 :: without sync block
	public static LazyRegistrywithThreadingProductDBEntry getNonSyncInstance() {

		if (NON_SYNC_INSTANCE == null) {
			NON_SYNC_INSTANCE = new LazyRegistrywithThreadingProductDBEntry();
		}

		return NON_SYNC_INSTANCE;
	}

	// CASE 2 :: without double check locking
	public static LazyRegistrywithThreadingProductDBEntry getDoubleChkInstance() {
		if (DBL_CHK_INSTANCE == null) {
			synchronized (LazyRegistrywithThreadingProductDBEntry.class) {
				DBL_CHK_INSTANCE = new LazyRegistrywithThreadingProductDBEntry();
			}
		}

		return DBL_CHK_INSTANCE;
	}

	// CASE 3 :: with double check locking(if condition) and Sync block BEST APPROACH
	public static LazyRegistrywithThreadingProductDBEntry getInstance() {
		if (INSTANCE == null) {
			synchronized (LazyRegistrywithThreadingProductDBEntry.class) {
				if (INSTANCE == null) {
					INSTANCE = new LazyRegistrywithThreadingProductDBEntry();
				}
			}
		}
		return INSTANCE;
	}
	public Map<String, String> putProduct(ProductItem product) {
		// Assume DB connection is happening
		productCache.put(product.getId(), product.getName());
		return productCache;
	}
}
