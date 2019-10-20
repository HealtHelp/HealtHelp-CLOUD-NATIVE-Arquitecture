package com.healthelp.patient;

import com.healthelp.patient.dao.PatientDao;
import com.healthelp.patient.model.documents.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import java.util.UUID;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	private static final Logger logg = LoggerFactory.getLogger(RestApplication.class);

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Autowired
	private PatientDao patientDao;

	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




		reactiveMongoTemplate.dropCollection("patient").subscribe();
		UUID tenantId = UUID.randomUUID();
		UUID userId = UUID.randomUUID();
		Flux.just(new Patient(1 , "Maria", "Pizarro","71107899T","625589030","C/El Cid, 28", "Madrid","Abogada","mariaP@gmail.com",1),
				new Patient(1 , "Maria", "Perez","71457899T","625699030","C/El Mar, 28", "Madrid","mariaP@gmail.com","mariaP@gmail.com",1),
				new Patient(1 , "Olga", "Honrubia","71433899J","625699030","C/Santa Ana, 28", "Madrid","mariaP@gmail.com","mariaP@gmail.com",1),
				new Patient(1 , "Olga", "Cano","71433799J","625699034","C/Santa Ana, 28", "Madrid","olga@gmail.com","mariaP@gmail.com",1),
				new Patient(1 , "Ruben", "Valle","71457229O","625699030","C/El Arbol, 28", "Madrid","mariaP@gmail.com","mariaP@gmail.com",1)
		).flatMap(item -> patientDao.save(item)).subscribe(item -> logg.info("Insert: "+item.toString()));
	}
}
