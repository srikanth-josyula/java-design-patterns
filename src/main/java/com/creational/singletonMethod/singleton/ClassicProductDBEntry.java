package com.creational.singletonMethod.singleton;

import java.util.HashMap;
import java.util.Map;
import com.creational.singletonMethod.model.Product;

public class ClassicProductDBEntry {

    private Map<String, String> productCache = new HashMap<>();

    private volatile static ClassicProductDBEntry INSTANCE;

    private ClassicProductDBEntry() {
        System.out.println("ProductDBEntry instance created.");
    }

    public static ClassicProductDBEntry getInstance() {
        if (INSTANCE == null) {
            synchronized (ClassicProductDBEntry.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClassicProductDBEntry();
                }
            }
        }
        return INSTANCE;
    }

    public Map<String, String> putProduct(Product product) {
        // Store product in cache using its category as the key
        productCache.put(product.getCategory(), product.getType());

        // Prepare and return detailed information
        Map<String, String> productInfo = new HashMap<>();
        productInfo.put("category", product.getCategory());
        productInfo.put("type", product.getType());

        return productInfo;
    }
}
