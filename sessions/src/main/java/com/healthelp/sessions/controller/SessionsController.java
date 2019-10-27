package com.healthelp.sessions.controller;

import com.healthelp.sessions.model.Sessions;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public interface SessionsController {

    @GetMapping(path = "/sessions",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Flux<Sessions>> getSessions();


    @GetMapping(path = "/sessions/patientId",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Flux<Sessions>> getSessionsByPatientId(@RequestParam("patientId") Integer patientId);






}


