package com.structural.decoratorPattern.decorator;

import com.structural.decoratorPattern.service.Product;

// ProductDecorator.java (Decorator)
public abstract class ProductDecorator implements Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public void produce() {
        decoratedProduct.produce();
    }
}
