package com.creational.abstractFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.abstractFactory.model.products.Products;
import com.creational.abstractFactory.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// Abstract Factory Method Pattern
	@GetMapping("abstractFactory/createProduct")
	public String createProduct(@RequestParam String category, @RequestParam String productType) {
		Products productName = productService.createProduct(category, productType);
		return "Created Product: " + productName.getClass();
	}
}
