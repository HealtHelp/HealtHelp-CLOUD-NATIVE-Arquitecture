package com.healthelp.oauth.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;


@Component
public class AuthenticationHandler implements AuthenticationEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        String name =  authentication.getName();
        log.info(" -- WELCOME to HEALTHELP Organization {}",name);
    }



    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        log.error(" -- ERROR LOGIN {}",exception.getMessage());
    }
}
