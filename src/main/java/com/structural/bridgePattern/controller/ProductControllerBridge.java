package com.structural.bridgePattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.structural.bridgePattern.abstraction.Product;
import com.structural.bridgePattern.abstraction.abstractimpl.ElectronicProduct;
import com.structural.bridgePattern.abstraction.abstractimpl.GroceryProduct;
import com.structural.bridgePattern.implementation.impl.ElectronicProductType;
import com.structural.bridgePattern.implementation.impl.GroceryProductType;

@RestController
public class ProductControllerBridge {
	
	@GetMapping("/bridge/produce")
    public String produceProduct(@RequestParam String type) {
       
		Product product;

        if ("electronic".equalsIgnoreCase(type)) {
            product = new ElectronicProduct(new ElectronicProductType());
        } else if ("grocery".equalsIgnoreCase(type)) {
            product = new GroceryProduct(new GroceryProductType());
        } else {
            return "Unknown product type";
        }

        product.produce();
        return "Product produced successfully!";
    }
}
