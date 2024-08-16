package com.sample.service.factory;

import com.sample.model.products.Products;

//Abstract Factory Interface
public interface ProductFactory {
    Products createProduct(String productType);
}
