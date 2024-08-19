package com.creational.builderMethod.builder;

import java.util.Map;

import com.creational.builderMethod.model.ProductItem;

public class ProductBuilder {
	private final String name;
	private final double price;
	private String color;
	private String size;
	private String warranty;
	private Map<String, String> configuration;

	// Mandatory fields constructor
	public ProductBuilder(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// Optional fields setters
	public ProductBuilder color(String color) {
		this.color = color;
		return this;
	}

	public ProductBuilder size(String size) {
		this.size = size;
		return this;
	}

	public ProductBuilder warranty(String warranty) {
		this.warranty = warranty;
		return this;
	}

	public ProductBuilder configuration(Map<String, String> configuration) {
		this.configuration = configuration;
		return this;
	}

	// Build method to create Product instance
	public ProductItem build() {
		return new ProductItem(this);
	}

	// Getters for Product class to access fields
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

	public Map<String, String> getConfiguration() {
		return configuration;
	}
}
