package com.creational.objectpooling.model;

public class Product {
    private final String category;
    private final String type;

    public Product(String category, String type) {
        this.category = category;
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    // Method to reset the product state before returning to the pool
    public void reset() {
        // Reset any fields if necessary
    }

    @Override
    public String toString() {
        return "Product{" +
               "category='" + category + '\'' +
               ", type='" + type + '\'' +
               '}';
    }
}
