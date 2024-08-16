package com.sample.model.products.impl;

import com.sample.model.products.GroceryProducts;

public class Produce implements GroceryProducts {
    @Override
    public void viewDetails() {
        System.out.println("Viewing details of Produce...");
    }

    @Override
    public void createProduce() {
        System.out.println("Creating Produce...");
    }

    @Override
    public void createPantry() {
        throw new UnsupportedOperationException("Produce can't create pantry items.");
    }
}
