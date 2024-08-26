package com.structural.decoratorPattern.service.impl;

import com.structural.decoratorPattern.service.Product;

//GroceryProduct.java (Concrete Component)
public class GroceryProduct implements Product {
 @Override
 public void produce() {
     System.out.println("Producing a Grocery Product.");
 }
}