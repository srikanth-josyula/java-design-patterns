package com.creational.abstractFactory.factory.impl;

import com.creational.abstractFactory.factory.ProductFactory;
import com.creational.abstractFactory.products.Product;
import com.creational.abstractFactory.products.concrete.groceries.PantryProduct;
import com.creational.abstractFactory.products.concrete.groceries.ProduceProduct;

public class GroceryProductFactory implements ProductFactory {

    @Override
    public Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "produce":
                return new ProduceProduct();
            case "pantry":
                return new PantryProduct();
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}
