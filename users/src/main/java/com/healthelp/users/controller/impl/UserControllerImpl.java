package com.healthelp.users.controller.impl;

import com.healthelp.users.controller.UserController;

import com.healthelp.users.model.dto.UserDTO;
import com.healthelp.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class UserControllerImpl implements UserController {

    private static final Logger log = LoggerFactory.getLogger(UserControllerImpl.class);
    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDTO> findByUsername(String username) {
        log.info(" -- GET /username {}",username);
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }
}
