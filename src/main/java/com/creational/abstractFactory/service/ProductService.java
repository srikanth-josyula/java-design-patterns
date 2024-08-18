package com.creational.abstractFactory.service;

import org.springframework.stereotype.Service;

import com.creational.abstractFactory.model.products.Products;
import com.creational.abstractFactory.service.factory.ProductFactory;
import com.creational.abstractFactory.service.factory.impl.ElectronicProductFactory;
import com.creational.abstractFactory.service.factory.impl.GroceryProductFactory;

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
