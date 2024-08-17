package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.ProductItem;
import com.sample.model.products.ElectronicProducts;
import com.sample.model.products.Products;
import com.sample.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// Abstract Factory Method Pattern
	@GetMapping("/createProduct")
	public String createProduct(@RequestParam String category, @RequestParam String productType) {
		Products productName = productService.createProduct(category, productType);
		return "Created Product: " + productName.getClass();
	}

	// Singleton
	@GetMapping("/product")
	public ProductItem getProduct(@RequestParam String productId) {
		return productService.getProduct(productId);
	}
	
	// Prototype Pattern Example
    @GetMapping("/cloneProduct")
    public String cloneProduct(@RequestParam String category, @RequestParam String productType) {
        ElectronicProducts originalProduct = (ElectronicProducts) productService.createProduct(category, productType);
        ElectronicProducts clonedProduct = (ElectronicProducts) originalProduct.clone();
        return "Original Product: " + originalProduct.getClass().getSimpleName() + 
               " | Cloned Product: " + clonedProduct.getClass().getSimpleName() + 
               " | Clone HashCode: " + System.identityHashCode(clonedProduct);
    }
}
