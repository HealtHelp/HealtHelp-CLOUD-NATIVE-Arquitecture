package com.healthelp.users.boot.configuration;

import com.healthelp.users.boot.properties.Properties;
import com.healthelp.users.controller.UserController;
import com.healthelp.users.controller.impl.UserControllerImpl;
import com.healthelp.users.dao.UserDao;
import com.healthelp.users.service.UserService;
import com.healthelp.users.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class ApiConfig {

    @Bean
    public Properties properties(){
        return new Properties();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Bean
    public UserService userService(UserDao userDao,BCryptPasswordEncoder bCryptPasswordEncoder){
        return new UserServiceImpl(userDao,bCryptPasswordEncoder);
    }

    @Bean
    public UserController userController(UserService userService, EntityLinks entityLinks){
        return new UserControllerImpl(userService, entityLinks);
    }



}
