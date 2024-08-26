package com.structural.flyweightPattern.service.impl;

import com.structural.flyweightPattern.service.Product;

//ConcreteFlyweight.java
public class ConcreteProduct implements Product {
 private String type; // The intrinsic state that is shared

 public ConcreteProduct(String type) {
     this.type = type;
 }

 @Override
 public void produce() {
     System.out.println("Producing " + type + " product.");
 }
}
