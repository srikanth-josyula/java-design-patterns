package com.creational.abstractFactory.products.concrete.groceries;

import com.creational.abstractFactory.products.Product;

public class ProduceProduct implements Product {

    @Override
    public void create() {
        System.out.println("Creating Produce Product.");
    }
}
