package com.healthelp.sessions.controller.impl;

import com.healthelp.sessions.controller.SessionsController;
import com.healthelp.sessions.model.Sessions;
import com.healthelp.sessions.model.dummy.SessionDummy;
import com.healthelp.sessions.service.SessionsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;



public class SessionsControllerImpl implements SessionsController {

    private SessionsService sessionsService;

    public SessionsControllerImpl(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @Override
    public ResponseEntity<Flux<Sessions>> getSessions() {
        return new ResponseEntity<>(sessionsService.getSessions(), HttpStatus.OK);
    }

    @HystrixCommand(fallbackMethod = "alternativeDummy")
    @Override
    public ResponseEntity<Flux<Sessions>> getSessionsByPatientId(Integer patientId) {
        return new ResponseEntity<>(sessionsService.getSessionsByPatientId(patientId),HttpStatus.OK);
    }

    public ResponseEntity<Flux<Sessions>> alternativeDummy(Integer patientId){
        return SessionDummy.dummyResponseEntityFluxSessions(patientId);
    }
}
