package com.structural.proxyPattern.service.impl;

import com.structural.proxyPattern.service.Product;

//ElectronicProduct.java (Concrete Component)
public class ElectronicProduct implements Product {
	
	@Override
	public void produce() {
		System.out.println("Producing an Electronic Product.");
	}
}