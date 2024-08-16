package com.sample.model.users.impl;

import com.sample.model.users.User;

public class Admin implements User {
	@Override
	public void accessPortal() {
		System.out.println("Accessing Admin Portal...");
	}
}
