package com.creational.builderMethod.builder;

import com.creational.builderMethod.model.Product;

public class ProductBuilder {
	public final String category;
	public final String type;
	public String name = ""; // Default optional values
	public double price = 0.0; // Default optional values

	public ProductBuilder(String category, String type) {
		this.category = category.toLowerCase();
		this.type = type;
	}

	public ProductBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public ProductBuilder setPrice(double price) {
		this.price = price;
		return this;
	}

	public Product build() {
		return new Product(this);

	}
}
