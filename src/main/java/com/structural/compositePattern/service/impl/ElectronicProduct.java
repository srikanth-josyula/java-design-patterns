package com.structural.compositePattern.service.impl;

import com.structural.compositePattern.service.Product;

//ElectronicProduct.java (Leaf)
public class ElectronicProduct implements Product {
    @Override
    public void produce() {
        System.out.println("Producing an Electronic Product.");
    }
}