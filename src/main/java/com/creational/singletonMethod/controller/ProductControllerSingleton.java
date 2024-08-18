package com.creational.singletonMethod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.singletonMethod.service.ProductServiceSingleton;

@RestController
public class ProductControllerSingleton {

    @Autowired
    private ProductServiceSingleton productService;

    @GetMapping("/singleton/add/product")
    public String addProduct(@RequestParam String productType) {
        return productService.addProduct(productType);
    }
}
