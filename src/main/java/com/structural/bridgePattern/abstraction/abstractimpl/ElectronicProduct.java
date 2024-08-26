package com.structural.bridgePattern.abstraction.abstractimpl;

import com.structural.bridgePattern.abstraction.Product;
import com.structural.bridgePattern.implementation.ProductType;

//ElectronicProduct.java (Refined Abstraction)
public class ElectronicProduct extends Product {
 public ElectronicProduct(ProductType productType) {
     super(productType);
 }

 @Override
 public void produce() {
     System.out.print("Electronic Product: ");
     productType.createProduct();
 }
}
