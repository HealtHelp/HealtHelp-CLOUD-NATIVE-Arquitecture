package com.healthelp.patient.service.impl;

import com.healthelp.patient.dao.PatientDao;
import com.healthelp.patient.model.documents.Patient;
import com.healthelp.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@Slf4j
public class PatientServiceImpl  implements PatientService {

    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Flux<Patient> getPatients() {
        return patientDao.findAll()//.flatMap(Mono::just).delayElements(Duration.ofSeconds(3))
                .doOnNext(item -> log.info(" -- GET /patients  name: {}",item.getName()));

    }

    @Override
    public Mono<Patient> getPatientsById(String id) {
        return  patientDao.findById(id).defaultIfEmpty(new Patient())
                .doOnNext(item -> log.info(" -- GET /patients/{} ",id));
    }

    @Override
    public Flux<Patient> getPatientsByNameAndUserId( String name, Integer userId) {
        return patientDao.findAll().flatMap(item -> {
            if( item.getName().equals(name) && item.getUserId().equals(userId)){
                return Flux.just(item);
            }
            else{
                return Flux.empty();
            }
        }).doOnNext(item -> log.info(" -- GET /patientByName {} {}",item.getName(),item.getLastName()));
    }
}
