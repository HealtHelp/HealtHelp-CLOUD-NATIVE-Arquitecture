package com.healthelp.oauth.security;

import com.healthelp.oauth.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenAdditionalData implements TokenEnhancer,UserSecurity {

    private RestTemplate restTemplate;
    private UserSecurity userSecurity;
    @Autowired
    public TokenAdditionalData(RestTemplate restTemplate, UserSecurity userSecurity){
        this.restTemplate = restTemplate;
        this.userSecurity = userSecurity;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        System.out.println(authentication);
        Map<String,Object> info = new HashMap<>();
        UserDTO userDTO = userSecurity.findByUserName(authentication.getName());
        info.put("username",userDTO.getUsername());
        info.put("email",userDTO.getEmail());
        info.put("tenantId",userDTO.getTenantId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

    @Override
    public UserDTO findByUserName(String username) {
        String url = UriComponentsBuilder.fromUriString("http://localhost:8090/hhu/api/v1/users")
                .queryParam("username",username).toUriString();
        return  restTemplate.getForObject(url, UserDTO.class);
    }
}
