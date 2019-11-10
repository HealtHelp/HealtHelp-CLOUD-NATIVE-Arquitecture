package com.healthelp.zuul.filters.oauth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Objects;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hho/**").permitAll()
                .antMatchers(HttpMethod.GET,"/hhu/users/**").permitAll()
                .antMatchers(HttpMethod.GET,"/hhb/**").hasRole("ADMIN")
                .anyRequest().permitAll();

    }



    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessToken());
    }

    @Bean
    public JwtAccessTokenConverter accessToken() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(Objects.requireNonNull(environment.getProperty("config.security.oauth.jwt.key")));
        return jwtAccessTokenConverter;
    }
}
