package com.healthelp.patient.dao;

import com.healthelp.patient.model.documents.Patient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PatientDao extends ReactiveMongoRepository<Patient,String> {
}
