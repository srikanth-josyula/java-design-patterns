package com.structural.compositePattern.service.impl;

import com.structural.compositePattern.service.Product;

//GroceryProduct.java (Leaf)
public class GroceryProduct implements Product {
 @Override
 public void produce() {
     System.out.println("Producing a Grocery Product.");
 }
}