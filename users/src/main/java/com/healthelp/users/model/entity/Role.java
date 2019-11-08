package com.healthelp.users.model.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role")
    private String role;

    public Role(Long id,String role) {
        this.id = id;
        this.role = role;
    }

    public Role(){}
}
