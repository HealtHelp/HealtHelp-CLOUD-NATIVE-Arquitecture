package com.healthelp.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userDetailsService;
    private AuthenticationEventPublisher  authenticationEventPublisher;

    @Autowired
    public SecurityConfig(UserService userDetailsService,AuthenticationEventPublisher  authenticationEventPublisher) {
        this.userDetailsService = userDetailsService;
        this.authenticationEventPublisher = authenticationEventPublisher;
    }

    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(cryptPasswordEncoder())
                .and()
                .authenticationEventPublisher(authenticationEventPublisher);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
