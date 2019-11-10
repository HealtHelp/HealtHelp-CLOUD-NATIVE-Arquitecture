package com.healthelp.users.boot.configuration;

import com.healthelp.users.boot.properties.Properties;
import com.healthelp.users.controller.UserController;
import com.healthelp.users.controller.impl.UserControllerImpl;
import com.healthelp.users.dao.UserDao;
import com.healthelp.users.service.UserService;
import com.healthelp.users.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.server.EntityLinks;


@Configuration
public class ApiConfig {

    @Bean
    public Properties properties(){
        return new Properties();
    }



    @Bean
    public UserService userService(UserDao userDao){
        return new UserServiceImpl(userDao);
    }

    @Bean
    public UserController userController(UserService userService, EntityLinks entityLinks, Properties properties, Environment environment){
        return new UserControllerImpl(userService, entityLinks, properties,environment);
    }



}
