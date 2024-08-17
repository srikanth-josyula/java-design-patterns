package com.creational.factory.model.users.impl;

import com.creational.factory.model.users.User;

public class Customer implements User {
    @Override
    public void accessPortal() {
        System.out.println("Accessing Customer Portal...");
    }
}
