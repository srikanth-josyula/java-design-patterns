package com.structural.facadePattern.service.impl;

import com.structural.facadePattern.service.Product;

//GroceryProduct.java (Concrete Component)
public class GroceryProduct implements Product {
	
 @Override
 public void produce() {
     System.out.println("Producing a Grocery Product.");
 }
}