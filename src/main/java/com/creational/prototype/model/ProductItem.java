package com.creational.prototype.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductItem implements Cloneable {

    private String id;
    private String name;
    private double price;
    private Map<String, String> configuration; // Complex nested object

    // Constructor
    public ProductItem(String name, double price) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.name = name;
        this.price = price;
        this.configuration = new HashMap<>(); // Initialize with default configuration
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String key, String value) {
        this.configuration.put(key, value);
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public ProductItem clone() throws CloneNotSupportedException {
        ProductItem cloned = (ProductItem) super.clone(); // Shallow copy
        // Configuration map is shared, no new map created
        return cloned;
    }

    public ProductItem deepClone() {
        try {
            ProductItem cloned = (ProductItem) super.clone(); // Shallow copy
            cloned.configuration = new HashMap<>(this.configuration); // Deep copy of the configuration map
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "ProductItem{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + price + ", configuration="
                + configuration + '}';
    }
}
