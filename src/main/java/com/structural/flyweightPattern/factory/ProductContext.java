package com.structural.flyweightPattern.factory;

import com.structural.flyweightPattern.service.Product;

public class ProductContext {
    private ProductFactory factory = new ProductFactory();

    public void produceProduct(String type, String features) {
        Product product = factory.getProduct(type);

        // Apply features here
        System.out.println("Applying features: " + features);
        product.produce();
    }
}
