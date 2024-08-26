package com.creational.abstractFactory.products.concrete.electronics;

import com.creational.abstractFactory.products.Product;

public class MobileProduct implements Product {

    @Override
    public void create() {
        System.out.println("Creating Mobile Product.");
    }
}
