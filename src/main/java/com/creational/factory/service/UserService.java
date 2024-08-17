package com.creational.factory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creational.factory.model.users.User;
import com.creational.factory.service.factory.UserFactory;

@Service
public class UserService {

	@Autowired
    UserFactory userFactory;

    public User getUser(String userType) {
    	//making use of user factory to create user instances
        return userFactory.createUser(userType);
    }
}
