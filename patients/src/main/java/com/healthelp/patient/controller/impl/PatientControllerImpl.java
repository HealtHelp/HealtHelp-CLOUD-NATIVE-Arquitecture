package com.healthelp.patient.controller.impl;

import com.healthelp.patient.controller.PatientController;
import com.healthelp.patient.model.documents.Patient;
import com.healthelp.patient.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public class PatientControllerImpl implements PatientController {

    private PatientService patientService;

    public PatientControllerImpl(PatientService patientService){
        this.patientService = patientService;
    }


    @Override
    public ResponseEntity<Flux<Patient>> getPatients() {
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Mono<Patient>> getPatientsById(String id) {
        return new ResponseEntity<>(patientService.getPatientsById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Flux<Patient>> getPatientsByNameAndUserId(String name, Integer userId) {
        return new ResponseEntity<>(patientService.getPatientsByNameAndUserId(name,userId),HttpStatus.OK);
    }


}
