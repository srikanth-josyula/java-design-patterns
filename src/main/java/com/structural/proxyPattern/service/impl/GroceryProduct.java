package com.structural.proxyPattern.service.impl;

import com.structural.proxyPattern.service.Product;

//GroceryProduct.java (Concrete Component)
public class GroceryProduct implements Product {
	
 @Override
 public void produce() {
     System.out.println("Producing a Grocery Product.");
 }
}