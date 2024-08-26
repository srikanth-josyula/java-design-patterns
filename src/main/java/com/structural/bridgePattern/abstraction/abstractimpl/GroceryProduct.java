package com.structural.bridgePattern.abstraction.abstractimpl;

import com.structural.bridgePattern.abstraction.Product;
import com.structural.bridgePattern.implementation.ProductType;

//GroceryProduct.java (Refined Abstraction)
public class GroceryProduct extends Product {
 public GroceryProduct(ProductType productType) {
     super(productType);
 }

 @Override
 public void produce() {
     System.out.print("Furniture Product: ");
     productType.createProduct();
 }
}
