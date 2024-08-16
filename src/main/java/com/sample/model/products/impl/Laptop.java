package com.sample.model.products.impl;

import com.sample.model.products.ElectronicProducts;

public class Laptop implements ElectronicProducts {
    @Override
    public void viewDetails() {
        System.out.println("Viewing details of Laptop...");
    }

    @Override
    public void createMobiles() {
        throw new UnsupportedOperationException("Laptops can't create mobiles.");
    }

    @Override
    public void createLaptops() {
        System.out.println("Creating Laptop...");
    }
}
