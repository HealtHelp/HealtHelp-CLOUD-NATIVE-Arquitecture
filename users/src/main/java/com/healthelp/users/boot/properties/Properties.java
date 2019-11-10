package com.healthelp.users.boot.properties;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Properties {

    @Value("${server.port}")
    private String port;

}
