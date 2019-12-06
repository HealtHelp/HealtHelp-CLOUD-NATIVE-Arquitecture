package com.healthelp.users.service.impl;

import com.healthelp.users.dao.UserDao;
import com.healthelp.users.model.entity.User;
import com.healthelp.users.model.dto.UserDTO;
import com.healthelp.users.model.exceptions.HandleExceptionFindUserName;
import com.healthelp.users.model.map.UserMapper;
import com.healthelp.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {


    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl .class);
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user;
        try{
            user = userDao.findByUsername(username);
            return UserMapper.mapUserToUserDTO(user);
        }catch (Exception ex){
            log.error(" -- ERROR HEALTHELP {}",ex.getMessage());
            throw new HandleExceptionFindUserName(ex);
        }
    }
}
