package com.sample.service.factory;

import org.springframework.context.annotation.Configuration;

import com.sample.model.users.User;
import com.sample.model.users.impl.Admin;
import com.sample.model.users.impl.Customer;
import com.sample.model.users.impl.Seller;

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
