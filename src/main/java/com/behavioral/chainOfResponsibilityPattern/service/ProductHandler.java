package com.behavioral.chainOfResponsibilityPattern.service;

//Product.java (Component)
public interface ProductHandler {
    void handleRequest(String type, String features);
    void setNextHandler(ProductHandler nextHandler);
}

