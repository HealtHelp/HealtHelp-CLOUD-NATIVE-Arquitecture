package com.healthelp.oauth.model;



import java.io.Serializable;

public class Role implements Serializable {
    private Long id;
    private String role;
    public Role(){}

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
