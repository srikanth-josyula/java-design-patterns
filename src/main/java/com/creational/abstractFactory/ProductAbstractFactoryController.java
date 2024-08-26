package com.creational.abstractFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.abstractFactory.factory.ProductFactory;
import com.creational.abstractFactory.factory.impl.ElectronicProductFactory;
import com.creational.abstractFactory.factory.impl.GroceryProductFactory;
import com.creational.abstractFactory.products.Product;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductAbstractFactoryController {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/abstract-factory/create/product")
	public ResponseEntity<String> createProduct(@RequestParam String category, @RequestParam String type) {
		ProductFactory factory;
		Product product;
		Map<String, Object> response = new HashMap<>();

		switch (category.toLowerCase()) {
		case "electronics":
			factory = new ElectronicProductFactory();
			break;
		case "groceries":
			factory = new GroceryProductFactory();
			break;
		default:
			response.put("category", category);
			response.put("type", type);
			response.put("className", "Unknown");
			response.put("hashCode", "Unknown");
			return ResponseEntity.ok(convertMapToJson(response));
		}

		product = factory.createProduct(type);
		String className = product.getClass().getSimpleName();
		String hashCode = Integer.toHexString(product.hashCode());

		response.put("category", category);
		response.put("type", type);
		response.put("className", className);
		response.put("hashCode", hashCode);

		return ResponseEntity.ok(convertMapToJson(response));
	}

	private String convertMapToJson(Map<String, Object> map) {
		try {
			return objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
			return "{}"; // Return empty JSON in case of an error
		}
	}
}
