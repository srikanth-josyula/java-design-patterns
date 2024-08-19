package com.creational.objectpooling.model;

import java.util.UUID;

/**
 * Mandatory: name, price Optional: color, size, warranty, accessories
 */
public class ProductItem implements Cloneable {

	private String id;
	private String name;
	private double price;

	public ProductItem(String name, double price) {
		this.id = UUID.randomUUID().toString(); // Generate a unique ID
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductItem{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + price + '}';
	}

}
