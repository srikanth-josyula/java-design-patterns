package com.creational.factoryMethod.model.users.impl;

import com.creational.factoryMethod.model.users.User;

public class Admin implements User {
	@Override
	public void accessPortal() {
		System.out.println("Accessing Admin Portal...");
	}
}
