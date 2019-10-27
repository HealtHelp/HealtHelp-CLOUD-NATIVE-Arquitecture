package com.healthelp.sessions;

import com.healthelp.sessions.dao.SessionsDao;
import com.healthelp.sessions.model.Sessions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.Date;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class SessionsApplication implements CommandLineRunner {

	private static final Logger logg = LoggerFactory.getLogger(SessionsApplication.class);

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Autowired
	private SessionsDao sessionsDao;

	public static void main(String[] args) {
		SpringApplication.run(SessionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reactiveMongoTemplate.dropCollection("session").subscribe();
		Flux.just(
				new Sessions(new Date(),1,"Diagnosis 1","Exploration 1","Treatment 1","Reason 1","Background 1","Complementary 1"),
				new Sessions(new Date(),1,"Diagnosis 2","Exploration 2","Treatment 2","Reason 2","Background 2","Complementary 2"),
				new Sessions(new Date(),2,"Diagnosis 3","Exploration 3","Treatment 3","Reason 3","Background 3","Complementary 3"),
				new Sessions(new Date(),4,"Diagnosis 4","Exploration 4","Treatment 4","Reason 4","Background 4","Complementary 4")
		).flatMap(item -> sessionsDao.save(item)).subscribe(item -> logg.info("Insert: "+item.toString()));
	}
}


