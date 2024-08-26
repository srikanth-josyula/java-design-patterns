package com.structural.compositePattern.composite;

//ProductBundle.java (Composite)
import java.util.ArrayList;
import java.util.List;

import com.structural.compositePattern.service.Product;

public class ProductBundle implements Product {
 private List<Product> products = new ArrayList<>();

 public void addProduct(Product product) {
     products.add(product);
 }

 public void removeProduct(Product product) {
     products.remove(product);
 }

 @Override
 public void produce() {
     System.out.println("Producing a Product Bundle:");
     for (Product product : products) {
         product.produce();
     }
 }
}
