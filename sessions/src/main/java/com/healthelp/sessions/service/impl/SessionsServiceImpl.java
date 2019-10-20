package com.healthelp.sessions.service.impl;

import com.healthelp.sessions.dao.SessionsDao;
import com.healthelp.sessions.model.Patient;
import com.healthelp.sessions.model.Sessions;
import com.healthelp.sessions.service.SessionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;



@Slf4j
public class SessionsServiceImpl implements SessionsService {

    private SessionsDao sessionsDao;


    public SessionsServiceImpl(SessionsDao sessionsDao ) {
        this.sessionsDao = sessionsDao;
    }

    @Override
    public Flux<Sessions> getSessions() {
        return sessionsDao.findAll().flatMap(Mono::just).delayElements(Duration.ofSeconds(1))
                .doOnNext(item -> SessionsServiceImpl.log.info(" -- GET /sessions  name: {}",item.getId()));
    }

    @Override
    public Flux<Sessions> getSessionsByPatientId(Integer patientId) {


        WebClient webClient = WebClient.create("http://localhost:8073");

        Flux<Patient> patientFlux = webClient.get()
                                             .uri("/api/v1/patients")
                                             .retrieve()
                                             .bodyToFlux(Patient.class);


        patientFlux.subscribe(item -> log.info(item.getName()));


          return sessionsDao.findAll().flatMap(item ->{
            if(patientId.equals(item.getPatientId())){
                return Flux.just(item);
            }
            else{
                return Flux.empty();
            }
        }).doOnNext(item -> SessionsServiceImpl.log.info(" -- GET /sessions  patientId: {}",item.getPatientId()));
    }


}
