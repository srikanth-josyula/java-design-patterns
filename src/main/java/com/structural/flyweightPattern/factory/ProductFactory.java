package com.structural.flyweightPattern.factory;


import java.util.HashMap;
import java.util.Map;

import com.structural.flyweightPattern.service.Product;
import com.structural.flyweightPattern.service.impl.ConcreteProduct;

public class ProductFactory {
    private Map<String, Product> productMap = new HashMap<>();

    public Product getProduct(String type) {
        Product product = productMap.get(type);
        if (product == null) {
            product = new ConcreteProduct(type);
            productMap.put(type, product);
        }
        return product;
    }
}

