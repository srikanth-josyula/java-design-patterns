package com.behavioral.chainOfResponsibilityPattern.handler.concrete;

import com.behavioral.chainOfResponsibilityPattern.handler.BaseProductHandler;

//ElectronicProductHandler.java
public class ElectronicProductHandler extends BaseProductHandler {
 @Override
 public void handleRequest(String type, String features) {
     if ("electronic".equalsIgnoreCase(type)) {
         System.out.println("Handling electronic product.");
         // Handle additional features if needed
         if (features != null) {
             System.out.println("Applying features: " + features);
         }
     } else {
         passToNext(type, features);
     }
 }
}