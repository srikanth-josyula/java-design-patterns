package com.creational.builderMethod.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.builderMethod.builder.ProductBuilder;
import com.creational.builderMethod.model.ProductItem;

@RestController
@RequestMapping("/builder/product")
public class ProductControllerBuilder {

	@GetMapping("/create")
	public ProductItem createProduct(@RequestParam String name, @RequestParam double price,
			@RequestParam(required = false, defaultValue = "") String color,
			@RequestParam(required = false, defaultValue = "") String size,
			@RequestParam(required = false, defaultValue = "") String warranty, 
			@RequestParam String ram,
			@RequestParam String storage) {

		Map<String, String> configurationMap = new HashMap<>();
		configurationMap.put("RAM", ram);
		configurationMap.put("Storage", storage);

		ProductItem product = new ProductBuilder(name, price)
				.color(color)
				.size(size)
				.warranty(warranty)
				.configuration(configurationMap)
				.build();

		return product;
	}

}
