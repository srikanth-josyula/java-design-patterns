package com.structural.bridgePattern.implementation.impl;

import com.structural.bridgePattern.implementation.ProductType;

//ElectronicProductType.java (Concrete Implementor)
public class ElectronicProductType implements ProductType {
 @Override
 public void createProduct() {
     System.out.println("Creating an Electronic Product.");
 }
}
