package com.healthelp.users.controller;

import com.healthelp.users.model.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public interface UserController {


    @GetMapping(path = "/userByName",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<EntityModel<UserDTO>> findByUsername(@RequestParam(name = "username") String username);

    @GetMapping(path = "/users",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<UserDTO>> getUsers(@Param("pageable") Pageable pageable);


}
