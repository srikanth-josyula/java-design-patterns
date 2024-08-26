package com.behavioral.chainOfResponsibilityPattern.handler.concrete;

import com.behavioral.chainOfResponsibilityPattern.handler.BaseProductHandler;

//GroceryProductHandler.java
public class GroceryProductHandler extends BaseProductHandler {
 @Override
 public void handleRequest(String type, String features) {
     if ("grocery".equalsIgnoreCase(type)) {
         System.out.println("Handling grocery product.");
         // Handle additional features if needed
         if (features != null) {
             System.out.println("Applying features: " + features);
         }
     } else {
         passToNext(type, features);
     }
 }
}