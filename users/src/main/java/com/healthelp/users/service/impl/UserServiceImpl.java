package com.healthelp.users.service.impl;

import com.healthelp.users.dao.UserDao;
import com.healthelp.users.model.entity.User;
import com.healthelp.users.model.dto.UserDTO;
import com.healthelp.users.model.exceptions.HandleExceptionFindUserName;
import com.healthelp.users.model.exceptions.HandleExceptionGetUsers;
import com.healthelp.users.model.exceptions.HandleExceptionSaveUsers;
import com.healthelp.users.model.map.UserMapper;
import com.healthelp.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {


    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl .class);
    private UserDao userDao;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao,BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
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

    @Override
    public List<UserDTO> getUsers(Pageable pageable) {
        pageable = pageRequest(pageable);
        List<User> users;
        try{
           users = userDao.findAll(pageable).stream().collect(Collectors.toList());
        }catch (Exception ex){
            log.error(" -- ERROR HEALTHELP {}",ex.getMessage());
            throw new HandleExceptionGetUsers(ex);
        }
        return UserMapper.mapListUserToListUserDTO(users);
    }

    @Override
    public UserDTO saveUser(User user) throws HandleExceptionSaveUsers {
        try{
            String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(password);
            return UserMapper.mapUserToUserDTO(userDao.save(user));
        }catch (Exception ex){
            log.error(" -- ERROR HEALTHELP {}",ex.getMessage());
            throw new HandleExceptionSaveUsers(ex);
        }
    }

    private PageRequest pageRequest(Pageable pageable){
        Sort sort = pageable.getSort();
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
    }
}
