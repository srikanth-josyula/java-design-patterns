package com.structural.decoratorPattern.service.impl;

import com.structural.decoratorPattern.service.Product;

//ElectronicProduct.java (Concrete Component)
public class ElectronicProduct implements Product {
	@Override
	public void produce() {
		System.out.println("Producing an Electronic Product.");
	}
}