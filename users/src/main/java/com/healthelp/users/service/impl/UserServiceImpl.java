package com.healthelp.users.service.impl;

import com.healthelp.users.dao.UserDao;
import com.healthelp.users.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
    }
}
