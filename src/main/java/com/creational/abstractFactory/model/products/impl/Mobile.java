package com.creational.abstractFactory.model.products.impl;

import com.creational.abstractFactory.model.products.ElectronicProducts;

public class Mobile implements ElectronicProducts {

	@Override
	public void viewDetails() {
		System.out.println("Viewing details of Mobile: ");
	}

	@Override
	public void createMobiles() {

		System.out.println("Creating Mobile...");

	}

	@Override
	public void createLaptops() {
		throw new UnsupportedOperationException("Mobiles can't create laptops.");
	}
}
