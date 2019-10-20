package com.healthelp.patient.model.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Document("patient")
public class Patient{
    @Id
    private String id;
    private UUID tenantId;
    private String name;
    private String lastName;
    private String dni;
    private String telephone;
    private String address;
    private String location;
    private String profession;
    private String email;
    private UUID userId;


    public Patient(UUID tenantId, String name,String lastName, String dni, String telephone, String address, String location, String profession, String email, UUID userId) {
        this.tenantId = tenantId;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.telephone = telephone;
        this.address = address;
        this.location = location;
        this.profession = profession;
        this.email = email;
        this.userId = userId;
    }


}
