package com.sample.cache;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.model.ProductItem;

//Singleton class
public class ProductCache {

    private static ProductCache instance;
    private Map<String, ProductItem> productCache = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ProductCache.class);

    private ProductCache() {
        logger.info("ProductCache instance created.");
    }

    public static synchronized ProductCache getInstance() {
        if (instance == null) {
            instance = new ProductCache();
        }
        return instance;
    }

    public ProductItem getProduct(String productId) {
        return productCache.get(productId);
    }

    public void putProduct(String productId, ProductItem product) {
        productCache.put(productId, product);
    }
}