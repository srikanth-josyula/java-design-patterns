package com.creational.factoryMethod.factory;

import org.springframework.context.annotation.Configuration;

import com.creational.factoryMethod.model.users.User;
import com.creational.factoryMethod.model.users.impl.Admin;
import com.creational.factoryMethod.model.users.impl.Customer;
import com.creational.factoryMethod.model.users.impl.Seller;

@Configuration
public class UserFactory {
    public User createUser(String userType) {
        switch (userType.toLowerCase()) {
            case "admin":
                return new Admin();
            case "customer":
                return new Customer();
            case "seller":
                return new Seller();
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
