package com.creational.builderMethod.model;

import com.creational.builderMethod.builder.ProductBuilder;

/**
 * Mandatory: category, type Optional: name, price
 */
public class Product {
    private final String category;  // Mandatory
    private final String type;      // Mandatory
    private String name;            // Optional
    private double price;           // Optional

    public Product(ProductBuilder builder) {
        this.category = builder.category;
        this.type = builder.type;
        this.name = builder.name;
        this.price = builder.price;
    }

    // Getters
    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}