package com.healthelp.sessions.boot.config;

import com.healthelp.sessions.controller.SessionsController;
import com.healthelp.sessions.controller.impl.SessionsControllerImpl;
import com.healthelp.sessions.dao.SessionsDao;
import com.healthelp.sessions.service.SessionsService;
import com.healthelp.sessions.service.impl.SessionsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;


@Configuration
public class ApiConfig {


    @Bean
    public WebClient webClient(){
       return WebClient
                .builder()
                .baseUrl("http://localhost:8073")
                .defaultCookie("server.port", "8073")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8073"))
                .build();
    }


    @Bean
    public SessionsService sessionsService(final SessionsDao sessionsDao,WebClient webClient){
        return new SessionsServiceImpl(sessionsDao,webClient);
    }

    @Bean
    public SessionsController sessionsController(final SessionsService sessionsService){
        return new SessionsControllerImpl(sessionsService);
    }
}
