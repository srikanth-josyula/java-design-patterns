package com.creational.abstractFactory.model.products.impl;

import com.creational.abstractFactory.model.products.GroceryProducts;

public class Pantry implements GroceryProducts {
    @Override
    public void viewDetails() {
        System.out.println("Viewing details of Pantry...");
    }

    @Override
    public void createProduce() {
        throw new UnsupportedOperationException("Pantry can't create produce items.");
    }

    @Override
    public void createPantry() {
        System.out.println("Creating Pantry...");
    }
}
