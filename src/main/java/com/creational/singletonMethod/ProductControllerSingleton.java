package com.creational.singletonMethod;

import com.creational.singletonMethod.model.Product;
import com.creational.singletonMethod.singleton.ClassicProductDBEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductControllerSingleton {

	private final ClassicProductDBEntry productDBEntry = ClassicProductDBEntry.getInstance();

	@GetMapping("/singleton/add/product")
	public ResponseEntity<String> createProduct(@RequestParam String category, @RequestParam String type) {
		Product product = new Product(category, type);

		// Add product to the database (singleton instance)
		Map<String, String> productEntry = productDBEntry.putProduct(product);

		// Prepare response data
		Map<String, Object> response = new HashMap<>();
		for (Map.Entry<String, String> entry : productEntry.entrySet()) {
			response.put(entry.getKey(), entry.getValue());
		}

		response.put("className", productDBEntry.getClass().getSimpleName());
		response.put("hashCode", Integer.toHexString(productDBEntry.hashCode()));

		return ResponseEntity.ok(convertMapToJson(response));
	}

	private String convertMapToJson(Map<String, Object> map) {
		try {
			return new ObjectMapper().writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
			return "{}"; // Return empty JSON in case of an error
		}
	}
}
