package com.structural.facadePattern.facade;

import com.structural.facadePattern.facade.concrete.GiftWrapDecorator;
import com.structural.facadePattern.service.Product;
import com.structural.facadePattern.service.impl.ElectronicProduct;
import com.structural.facadePattern.service.impl.GroceryProduct;

public class ProductFacade {
    public Product createProduct(String type) {
        if ("electronic".equalsIgnoreCase(type)) {
            return new ElectronicProduct();
        } else if ("grocery".equalsIgnoreCase(type)) {
            return new GroceryProduct();
        } else {
            throw new IllegalArgumentException("Unknown product type");
        }
    }

    public Product addGiftWrap(Product product) {
        return new GiftWrapDecorator(product);
    }

    public void produceProduct(Product product) {
        product.produce();
    }
}
