package com.healthelp.users.controller;

import com.healthelp.users.model.dto.UserDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public interface UserController {


    @GetMapping(path = "/users",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<EntityModel<UserDTO>> findByUsername(@RequestParam(name = "username") String username);


}
