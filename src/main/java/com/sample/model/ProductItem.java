package com.sample.model;

public class ProductItem {

    private String id;
    private String name;

    // Constructor
    public ProductItem(String id, String name) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ProductItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
