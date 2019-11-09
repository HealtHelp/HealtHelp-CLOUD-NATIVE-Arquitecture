package com.healthelp.oauth.security;

import com.healthelp.oauth.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements UserDetailsService,UserSecurity {

    private Logger log = LoggerFactory.getLogger(UserService.class);
    private RestTemplate restTemplate;
    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = findByUserName(username);
        if(userDTO == null){
            log.error(" -- User {} Not Found!!",username);
            throw new UsernameNotFoundException(" -- User Not Found!!");
        }
        List<GrantedAuthority> authorities = userDTO.getRoleList().stream().map(item -> new SimpleGrantedAuthority(item.getRole()))
                .peek(item -> log.info("Role: {}",item.getAuthority()))
                .collect(Collectors.toList());

        log.info("User authenticated {}",username);
        return new User(username,userDTO.getPassword(),true,true,true,true,authorities);
    }

    @Override
    public UserDTO findByUserName(String username) {
        String url = UriComponentsBuilder.fromUriString("http://localhost:8090/hhu/api/v1/users")
                .queryParam("username",username).toUriString();
        return  restTemplate.getForObject(url, UserDTO.class);
    }
}
