package com.creational.abstractFactory.service;

import org.springframework.stereotype.Service;

import com.creational.abstractFactory.factory.ProductFactory;
import com.creational.abstractFactory.factory.impl.ElectronicProductFactory;
import com.creational.abstractFactory.factory.impl.GroceryProductFactory;
import com.creational.abstractFactory.model.products.Products;

@Service
public class ProductService {

	public Products createProduct(String category, String productType) {

		// Abstract Fractiory Method
		ProductFactory factory;

		switch (category.toLowerCase()) {
		case "electronics":
			factory = new ElectronicProductFactory();
			break;
		case "groceries":
			factory = new GroceryProductFactory();
			break;
		default:
			throw new IllegalArgumentException("Unknown category: " + category);
		}

		return factory.createProduct(productType);
	}

}
