package com.creational.abstractFactory.products.concrete.groceries;

import com.creational.abstractFactory.products.Product;

public class PantryProduct implements Product {

    @Override
    public void create() {
        System.out.println("Creating Pantry Product.");
    }
}
