package com.creational.prototype.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.prototype.model.ProductItem;
import com.creational.prototype.service.ProductServicePrototype;

@RestController
@RequestMapping("/prototype/product")
public class ProductControllerPrototype {

	@Autowired
	private ProductServicePrototype productService;

	private ProductItem defaultProduct;

	// Default Product created object
	public ProductControllerPrototype() {
		long startTime = System.nanoTime();

		defaultProduct = new ProductItem("Laptop1", 1200.00);
		defaultProduct.setConfiguration("RAM", "8GB");
		defaultProduct.setConfiguration("Storage", "256GB SSD");

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time taken to create an object using new operator: " + totalTime);
	}

	@GetMapping("/clone/shallow")
	public List<Map<String, Object>> shallowCloneProduct(@RequestParam(value = "ram") String ram,
			@RequestParam(value = "storage") String storage) throws CloneNotSupportedException {

		long cloneStartTime = System.nanoTime();

		// Create a shallow copy of the default product
		ProductItem clonedProduct = productService.createShallowCopy(defaultProduct);

		// Modify the cloned product's configuration based on request parameters
		clonedProduct.setConfiguration("RAM", ram);
		clonedProduct.setConfiguration("Storage", storage);

		long cloneEndTime = System.nanoTime();
		long cloneTotalTime = cloneEndTime - cloneStartTime;
		System.out.println("Time taken to create an object using shallow cloning: " + cloneTotalTime);

		// Create response maps for original and cloned products
		Map<String, Object> originalProductMap = createProductResponseMap("original", defaultProduct);
		Map<String, Object> clonedProductMap = createProductResponseMap("cloned", clonedProduct);

		// Return both the original and cloned product in a list
		return Arrays.asList(originalProductMap, clonedProductMap);
	}

	@GetMapping("/clone/deep")
	public List<Map<String, Object>> deepCloneProduct(@RequestParam String ram, @RequestParam String storage) {
		long cloneStartTime = System.nanoTime();

		ProductItem clonedProduct = productService.createDeepCopy(defaultProduct);

		// Modify the cloned product's configuration
		clonedProduct.setConfiguration("RAM", ram);
		clonedProduct.setConfiguration("Storage", storage);

		long cloneEndTime = System.nanoTime();
		long cloneTotalTime = cloneEndTime - cloneStartTime;
		System.out.println("Time taken to create an object using deep cloning: " + cloneTotalTime);

		Map<String, Object> originalProductMap = createProductResponseMap("original", defaultProduct);
		Map<String, Object> clonedProductMap = createProductResponseMap("cloned", clonedProduct);

		// Return both the original and cloned product in a list
		return Arrays.asList(originalProductMap, clonedProductMap);
	}

	private Map<String, Object> createProductResponseMap(String origin, ProductItem product) {
		Map<String, Object> productMap = new HashMap<>();
		productMap.put("origin", origin);
		productMap.put("product", product);
		productMap.put("hashCode", product.hashCode());

		// Add field-specific hash codes
		productMap.put("nameHashCode", product.getName().hashCode());
		productMap.put("priceHashCode", Double.hashCode(product.getPrice()));
		productMap.put("configurationHashCode", product.getConfiguration().hashCode());

		return productMap;
	}

}
