package com.structural.decoratorPattern.decorator.concrete;

import com.structural.decoratorPattern.decorator.ProductDecorator;
import com.structural.decoratorPattern.service.Product;

//GiftWrapDecorator.java (Concrete Decorator)
public class GiftWrapDecorator extends ProductDecorator {
	
 public GiftWrapDecorator(Product decoratedProduct) {
     super(decoratedProduct);
 }

 @Override
 public void produce() {
     super.produce();
     addGiftWrap();
 }

 private void addGiftWrap() {
     System.out.println("Adding gift wrap to the product.");
 }
}