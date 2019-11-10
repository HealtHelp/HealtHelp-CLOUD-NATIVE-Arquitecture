package com.healthelp.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;
import java.util.Objects;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private BCryptPasswordEncoder cryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenAdditionalData  tokenAdditionalData;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(environment.getProperty("config.security.oauth.client.id"))
                .secret(cryptPasswordEncoder.encode(Objects.requireNonNull(environment.getProperty("config.security.oauth.client.secret"))))
                .scopes("read", "write")
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
                //.and()
                //.withClient() ;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenAdditionalData,accessToken()));
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessToken())
                .tokenEnhancer(tokenEnhancerChain);
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
