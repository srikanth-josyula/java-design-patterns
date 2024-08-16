package com.sample.model.users.impl;

import com.sample.model.users.User;

public class Seller implements User {
    @Override
    public void accessPortal() {
        System.out.println("Accessing Seller Portal...");
    }
}