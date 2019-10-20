package com.healthelp.patient.boot;

import com.healthelp.patient.controller.PatientController;
import com.healthelp.patient.controller.impl.PatientControllerImpl;
import com.healthelp.patient.dao.PatientDao;
import com.healthelp.patient.service.PatientService;
import com.healthelp.patient.service.impl.PatientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {


    @Bean
    public PatientService patientService(final PatientDao patientDao){
        return new PatientServiceImpl(patientDao);
    }

    @Bean
    public PatientController patientController(final PatientService patientService){
        return new PatientControllerImpl(patientService);
    }

}


