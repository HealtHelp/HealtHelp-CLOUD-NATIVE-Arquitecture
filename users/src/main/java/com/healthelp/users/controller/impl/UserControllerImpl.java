package com.healthelp.users.controller.impl;

import com.healthelp.users.controller.UserController;
import com.healthelp.users.service.UserService;

public class UserControllerImpl implements UserController {

    private UserService userService;


    public UserControllerImpl(UserService userService) {
    }
}
