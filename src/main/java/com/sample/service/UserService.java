package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.users.User;
import com.sample.service.factory.UserFactory;

@Service
public class UserService {
    @Autowired
    private UserFactory userFactory;

    public User getUser(String userType) {
    	//making use of user factory to create user instances
        return userFactory.createUser(userType);
    }
}
