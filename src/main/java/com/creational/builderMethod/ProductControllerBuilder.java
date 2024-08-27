package com.creational.builderMethod;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.builderMethod.builder.ProductBuilder;
import com.creational.builderMethod.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductControllerBuilder {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/builder/create/product")
	public ResponseEntity<String> createProduct(@RequestParam String category, @RequestParam String type,
			@RequestParam(required = false) String name, @RequestParam(required = false) Double price) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			// Creating Product using the mandatory constructor and optional setters

			Product product = new ProductBuilder(category, type)
					.setName(name)
					.setPrice(price)
					.build();

			String className = product.getClass().getSimpleName();
			String hashCode = Integer.toHexString(product.hashCode());

			response.put("category", product.getCategory());
			response.put("type", product.getType());
			response.put("name", product.getName());
			response.put("price", product.getPrice());
			response.put("className", className);
			response.put("hashCode", hashCode);
		} catch (IllegalArgumentException e) {
			response.put("category", category);
			response.put("type", type);
			response.put("className", "Unknown");
			response.put("hashCode", "Unknown");
		}

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