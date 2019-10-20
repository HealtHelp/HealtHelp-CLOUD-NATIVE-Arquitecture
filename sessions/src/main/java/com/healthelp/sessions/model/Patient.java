package com.healthelp.sessions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Document("patient")
public class Patient implements Serializable {
    @Id
    private String id;
    private Integer tenantId;
    private String name;
    private String lastName;
    private String dni;
    private String telephone;
    private String address;
    private String location;
    private String profession;
    private String email;
    private Integer userId;
}


