package com.healthelp.sessions.controller;

import com.healthelp.sessions.model.Sessions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public interface SessionsController {

    @GetMapping(path = "/sessions",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Flux<Sessions>> getSessions();
}


