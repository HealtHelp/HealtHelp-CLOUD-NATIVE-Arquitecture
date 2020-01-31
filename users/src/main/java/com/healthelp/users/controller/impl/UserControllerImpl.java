package com.healthelp.users.controller.impl;

import com.healthelp.users.controller.UserController;
import com.healthelp.users.model.dto.UserDTO;
import com.healthelp.users.model.entity.User;
import com.healthelp.users.model.exceptions.HandleExceptionSaveUsers;
import com.healthelp.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;



public class UserControllerImpl implements UserController {


    private static final Logger log = LoggerFactory.getLogger(UserControllerImpl.class);
    private UserService userService;
    private final EntityLinks entityLinks;

    public UserControllerImpl(UserService userService, EntityLinks entityLinks) {
        this.userService = userService;
        this.entityLinks = entityLinks;
    }


    @Override
    public ResponseEntity<EntityModel<UserDTO>> findByUsername(String username) {
        log.info(" -- GET /username {}",username);
        EntityModel<UserDTO> user = new EntityModel<>(userService.findByUsername(username));
        user.add(entityLinks.linkToItemResource(User.class, Objects.requireNonNull(user.getContent()).getId()));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsers(Pageable pageable) {
        log.info(" -- GET /users");
        return new ResponseEntity<>(userService.getUsers(pageable),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntityModel<Links>> insertCourse(User user) throws HandleExceptionSaveUsers {
        log.info(" -- POST /course");
        EntityModel<UserDTO> entity = new EntityModel<>(userService.saveUser(user));
        entity.add(entityLinks.linkToItemResource(User.class, Objects.requireNonNull(user.getId())));
        Links links = entity.getLinks();
        return new ResponseEntity(links,HttpStatus.OK);
    }


}
