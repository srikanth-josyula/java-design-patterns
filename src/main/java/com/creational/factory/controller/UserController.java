package com.creational.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.factory.model.users.User;
import com.creational.factory.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //Factory Method Pattern
    @GetMapping("factory/user/create")
    public String accessUserPortal(@RequestParam String userType) {
        User user = userService.getUser(userType);
        user.accessPortal();
        return "Accessed " + userType + " portal";
    }
}