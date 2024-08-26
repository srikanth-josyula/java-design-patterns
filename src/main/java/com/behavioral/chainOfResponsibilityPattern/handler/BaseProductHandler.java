package com.behavioral.chainOfResponsibilityPattern.handler;

import com.behavioral.chainOfResponsibilityPattern.service.ProductHandler;

//BaseProductHandler.java
public abstract class BaseProductHandler implements ProductHandler {

	protected ProductHandler nextHandler;

	@Override
	public void setNextHandler(ProductHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	protected void passToNext(String type, String features) {
		if (nextHandler != null) {
			nextHandler.handleRequest(type, features);
		} else {
			System.out.println("No handler found for type: " + type);
		}
	}
}