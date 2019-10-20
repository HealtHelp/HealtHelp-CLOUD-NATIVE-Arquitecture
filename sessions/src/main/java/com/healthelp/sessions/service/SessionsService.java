package com.healthelp.sessions.service;

import com.healthelp.sessions.model.Sessions;
import reactor.core.publisher.Flux;

public interface SessionsService {
    Flux<Sessions> getSessions();
}
