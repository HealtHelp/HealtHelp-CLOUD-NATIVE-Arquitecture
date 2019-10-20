package com.healthelp.patient.service;


import com.healthelp.patient.model.documents.Patient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PatientService{

    Flux<Patient> getPatients();

    Mono<Patient> getPatientsById(String id);
}
