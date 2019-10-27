package com.healthelp.sessions.model.dummy;

import com.healthelp.sessions.model.Sessions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.Date;

public class SessionDummy {
    public static ResponseEntity<Flux<Sessions>> dummyResponseEntityFluxSessions(Integer patientId){
        return new ResponseEntity<>(
                dummyFluxSessions(patientId), HttpStatus.NOT_FOUND);
    }

    private static Flux<Sessions> dummyFluxSessions(Integer patientId) {
        return Flux.just(
          Sessions.builder()
                  .date(new Date())
                  .patientId(patientId)
                  .diagnosis("No return diagnosis")
                  .exploration("No return exploration")
                  .treatment("No return treatment")
                  .reason("No return reason")
                .background("No return background")
                .complementary("No return complementary")
                .build()
        );
    }
}
/*
*  this.date = date;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.exploration = exploration;
        this.treatment = treatment;
        this.reason = reason;
        this.background = background;
        this.complementary = complementary;
*
* */