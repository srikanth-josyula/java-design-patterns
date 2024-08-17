package com.creational.factory.model.users.impl;

import com.creational.factory.model.users.User;

public class Admin implements User {
	@Override
	public void accessPortal() {
		System.out.println("Accessing Admin Portal...");
	}
}
