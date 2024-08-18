package com.creational.singletonMethod.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.creational.singletonMethod.cache.ProductDBEntry;
import com.creational.singletonMethod.model.ProductItem;

@Service
public class ProductServiceSingleton {

    public String addProduct(String productType) {
        ProductDBEntry productDBEntry = ProductDBEntry.getInstance();
        
        // Create a new product for demonstration purposes
        ProductItem product = new ProductItem(productType);
        
        // Add the product to the singleton's cache
        Map<String, String> productEntry = productDBEntry.putProduct(product);
        
        // Return a response including the hashcode and the product ID added
        return "ProductDBEntry HashCode: " + productDBEntry.hashCode() +
               ", Product Added: ID = " + product.getId() + ", Name = " + product.getName();
    }
}
