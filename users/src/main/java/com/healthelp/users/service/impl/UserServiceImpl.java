package com.healthelp.users.service.impl;

import com.healthelp.users.dao.UserDao;
import com.healthelp.users.model.User;
import com.healthelp.users.model.dto.UserDTO;
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
        log.info(username);
        User user = userDao.findByUsername(username);
        return UserMapper.mapUserToUserDTO(user);
    }
}
