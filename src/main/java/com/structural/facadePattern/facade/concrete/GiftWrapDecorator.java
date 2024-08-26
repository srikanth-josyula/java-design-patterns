package com.structural.facadePattern.facade.concrete;

import com.structural.facadePattern.service.Product;

public class GiftWrapDecorator implements Product {
    private Product decoratedProduct;

    public GiftWrapDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public void produce() {
        decoratedProduct.produce();
        addGiftWrap();
    }

    private void addGiftWrap() {
        System.out.println("Adding gift wrap to the product.");
    }
}