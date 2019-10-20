package com.healthelp.patient.dao;

import com.healthelp.patient.model.documents.Patient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface PatientDao extends ReactiveMongoRepository<Patient,String> {
}
