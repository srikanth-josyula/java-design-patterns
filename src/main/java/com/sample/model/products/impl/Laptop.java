package com.sample.model.products.impl;

import com.sample.model.products.ElectronicProducts;

public class Laptop implements ElectronicProducts {
    private String manufacturer;
    private String modelName;

    public Laptop() {}

    public Laptop(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    @Override
    public ElectronicProducts clone() {
        return new Laptop(this.manufacturer, this.modelName);
    }

    @Override
    public void viewDetails() {
        System.out.println("Viewing details of Laptop: " + manufacturer + " " + modelName);
    }

    @Override
    public void createMobiles(String manufacturer, String modelName) {
        throw new UnsupportedOperationException("Laptops can't create mobiles.");
    }

    @Override
    public void createLaptops() {
        System.out.println("Creating Laptop...");
    }
}
