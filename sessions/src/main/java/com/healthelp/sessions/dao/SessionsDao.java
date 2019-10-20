package com.healthelp.sessions.dao;

import com.healthelp.sessions.model.Sessions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SessionsDao extends ReactiveMongoRepository<Sessions,String> {
}
