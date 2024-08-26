package com.structural.decoratorPattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.structural.decoratorPattern.decorator.concrete.GiftWrapDecorator;
import com.structural.decoratorPattern.service.Product;
import com.structural.decoratorPattern.service.impl.ElectronicProduct;
import com.structural.decoratorPattern.service.impl.GroceryProduct;

@RestController
public class ProductControllerDecorator {

	@GetMapping("/decorator/produce")
	public String produceProduct(@RequestParam String type, @RequestParam(required = false) String features) {

		Product product;

		if ("electronic".equalsIgnoreCase(type)) {
			product = new ElectronicProduct();
		} else if ("grocery".equalsIgnoreCase(type)) {
			product = new GroceryProduct();
		} else {
			return "Unknown product type";
		}

		// Apply decorators based on features
		if (features != null) {

			if (features.contains("giftwrap")) {
				product = new GiftWrapDecorator(product);
			}
		}

		product.produce();
		return "Product produced successfully with the specified features!";
	}
}
