package com.sample.service;

import org.springframework.stereotype.Service;

import com.sample.cache.ProductCache;
import com.sample.model.ProductItem;
import com.sample.model.products.ElectronicProducts;
import com.sample.model.products.Products;
import com.sample.service.factory.ProductFactory;
import com.sample.service.factory.impl.ElectronicProductFactory;
import com.sample.service.factory.impl.GroceryProductFactory;

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

	// Singleton example
	public ProductItem getProduct(String productId) {

		ProductCache cache = ProductCache.getInstance();
		System.out.println("Cache HashCode: " + System.identityHashCode(cache));

		ProductItem product = cache.getProduct(productId);
		if (product != null) {
			return product;
		}
		product = loadProductFromDatabase(productId);
		cache.putProduct(productId, product);
		return product;
	}
	
	// prototype example
	  public ElectronicProducts cloneProduct(ElectronicProducts product) {
	        return product.clone();
	    }

	private ProductItem loadProductFromDatabase(String productId) {
		switch (productId) {
		case "1":
			return new ProductItem("1", "Smartphone");
		case "2":
			return new ProductItem("2", "Laptop");
		case "3":
			return new ProductItem("3", "Headphones");
		case "4":
			return new ProductItem("4", "Smartwatch");
		case "5":
			return new ProductItem("5", "Keyboard");
		default:
			throw new IllegalArgumentException("Product not found with ID: " + productId);
		}
	}
}
