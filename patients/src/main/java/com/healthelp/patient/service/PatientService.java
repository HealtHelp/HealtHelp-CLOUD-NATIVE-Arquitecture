package com.healthelp.patient.service;


import com.healthelp.patient.model.documents.Patient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface PatientService{

    Flux<Patient> getPatients();

    Mono<Patient> getPatientsById(String id);

    Flux<Patient> getPatientsByNameAndUserId( String name, Integer userId);
}
