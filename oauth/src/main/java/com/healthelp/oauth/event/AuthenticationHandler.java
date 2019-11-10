package com.healthelp.oauth.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationHandler implements AuthenticationEventPublisher {
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
