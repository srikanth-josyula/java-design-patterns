package com.structural.facadePattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.structural.facadePattern.facade.ProductFacade;
import com.structural.facadePattern.service.Product;

@RestController
public class ProductControllerFacade {

	private final ProductFacade productFacade = new ProductFacade();

	@GetMapping("/facade/produce")
	public String produceProduct(@RequestParam String type, @RequestParam(required = false) String features) {
		try {
			// Create the base product using the facade
			Product product = productFacade.createProduct(type);

			// Apply decorators based on features using the facade
			if (features != null) {
				if (features.contains("giftwrap")) {
					product = productFacade.addGiftWrap(product);
				}
			}

			// Produce the product using the facade
			productFacade.produceProduct(product);
			return "Product produced successfully with the specified features!";
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
	}
}