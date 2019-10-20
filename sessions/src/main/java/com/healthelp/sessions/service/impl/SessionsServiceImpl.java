package com.healthelp.sessions.service.impl;

import com.healthelp.sessions.dao.SessionsDao;
import com.healthelp.sessions.model.Sessions;
import com.healthelp.sessions.service.SessionsService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class SessionsServiceImpl implements SessionsService {

    private SessionsDao sessionsDao;
    public SessionsServiceImpl(SessionsDao sessionsDao) {
        this.sessionsDao = sessionsDao;
    }

    @Override
    public Flux<Sessions> getSessions() {
        return sessionsDao.findAll().flatMap(Mono::just).delayElements(Duration.ofSeconds(1))
                .doOnNext(item -> log.info(" -- GET /sessions  name: {}",item.getId()));
    }
}
