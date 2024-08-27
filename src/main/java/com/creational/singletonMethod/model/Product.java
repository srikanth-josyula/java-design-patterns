package com.creational.singletonMethod.model;

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

    @Override
    public String toString() {
        return "Product{" +
               "category='" + category + '\'' +
               ", type='" + type + '\'' +
               '}';
    }
}
