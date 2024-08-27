package com.creational.prototype.model;

import java.util.HashMap;
import java.util.Map;

public class Product implements Cloneable {

    private String category;
    private String type;
    private String name;
    private double price;
    private Map<String, String> configuration; // Complex nested object

    // Constructor
    public Product(String category, String type, String name, double price, Map<String, String> configuration) {
        this.category = category;
        this.type = type;
        this.name = name;
        this.price = price;
        this.configuration = configuration;
    }

    // Getter and Setter methods
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone(); // Shallow copy
    }

    public Product deepClone() {
        try {
            Product cloned = (Product) super.clone(); // Shallow copy
            cloned.configuration = new HashMap<>(this.configuration); // Deep copy of the configuration map
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}
