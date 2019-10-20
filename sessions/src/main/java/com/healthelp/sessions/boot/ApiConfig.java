package com.healthelp.sessions.boot;

import com.healthelp.sessions.controller.SessionsController;
import com.healthelp.sessions.controller.impl.SessionsControllerImpl;
import com.healthelp.sessions.dao.SessionsDao;
import com.healthelp.sessions.service.SessionsService;
import com.healthelp.sessions.service.impl.SessionsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ApiConfig {


    @Bean
    public SessionsService sessionsService(final SessionsDao sessionsDao ){
        return new SessionsServiceImpl(sessionsDao);
    }

    @Bean
    public SessionsController sessionsController(final SessionsService sessionsService){
        return new SessionsControllerImpl(sessionsService);
    }
}
