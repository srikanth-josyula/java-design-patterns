package com.creational.singletonMethod.model;

import java.util.UUID;

public class ProductItem {

    private String id;
    private String name;

    // Constructor
    public ProductItem(String name) {
        this.id = UUID.randomUUID().toString();  // Generate a unique ID
        this.name = name;
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
}
