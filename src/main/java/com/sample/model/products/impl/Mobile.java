package com.sample.model.products.impl;

import com.sample.model.products.ElectronicProducts;

public class Mobile implements ElectronicProducts {
    private String manufacturer;
    private String modelName;

    public Mobile() {}

    public Mobile(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    @Override
    public ElectronicProducts clone() {
        return new Mobile(this.manufacturer, this.modelName);
    }

    @Override
    public void viewDetails() {
        System.out.println("Viewing details of Mobile: " + manufacturer + " " + modelName);
    }

    @Override
    public void createMobiles(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        System.out.println("Creating Mobile...");
        // Demonstrate cloning
        Mobile clonedMobile = (Mobile) this.clone();
        System.out.println("Cloned Mobile: " + System.identityHashCode(clonedMobile));
    }

    @Override
    public void createLaptops() {
        throw new UnsupportedOperationException("Mobiles can't create laptops.");
    }
}
