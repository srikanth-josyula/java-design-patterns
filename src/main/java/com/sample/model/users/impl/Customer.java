package com.sample.model.users.impl;

import com.sample.model.users.User;

public class Customer implements User {
    @Override
    public void accessPortal() {
        System.out.println("Accessing Customer Portal...");
    }
}
