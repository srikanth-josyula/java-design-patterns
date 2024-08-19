package com.creational.builderMethod.model;

import java.util.Map;
import java.util.UUID;

import com.creational.builderMethod.builder.ProductBuilder;

/**
 * Mandatory: name, price Optional: color, size, warranty, accessories
 */
public class ProductItem implements Cloneable {

	private String id;
	private String name;
	private double price;
	private final String color;
	private final String size;
	private final String warranty;
	private Map<String, String> configuration; // Complex nested object

	// Private constructor to ensure object creation only via the builder
	public ProductItem(ProductBuilder builder) {
		this.id = UUID.randomUUID().toString(); // Generate a unique ID
		this.name = builder.getName();
		this.price = builder.getPrice();
		this.color = builder.getColor();
		this.size = builder.getSize();
		this.warranty = builder.getWarranty();
		this.configuration = builder.getConfiguration();
	}

	// Getters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public String getSize() {
		return size;
	}

	public String getWarranty() {
		return warranty;
	}

	public Map<String, String> configuration() {
		return configuration;
	}

	@Override
	public String toString() {
		return "ProductItem{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + price + ", color='" + color
				+ '\'' + ", size='" + size + '\'' + ", warranty='" + warranty + '\'' + ", configuration="
				+ configuration + '}';
	}
}
