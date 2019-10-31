package com.healthelp.users.controller;

import com.healthelp.users.model.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public interface UserController {
    @GetMapping(path = "/username",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserDTO> findByUsername(@RequestParam(name = "username") String username);
}
