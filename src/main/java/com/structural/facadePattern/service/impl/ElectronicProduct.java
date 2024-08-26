package com.structural.facadePattern.service.impl;

import com.structural.facadePattern.service.Product;

//ElectronicProduct.java (Concrete Component)
public class ElectronicProduct implements Product {
	
	@Override
	public void produce() {
		System.out.println("Producing an Electronic Product.");
	}
}