package com.healthelp.users.boot;

import com.healthelp.users.controller.UserController;
import com.healthelp.users.controller.impl.UserControllerImpl;
import com.healthelp.users.dao.UserDao;
import com.healthelp.users.service.UserService;
import com.healthelp.users.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public UserService userService(UserDao userDao){
        return new UserServiceImpl(userDao);
    }

    @Bean
    public UserController userController(UserService userService){
        return new UserControllerImpl(userService);
    }




}
