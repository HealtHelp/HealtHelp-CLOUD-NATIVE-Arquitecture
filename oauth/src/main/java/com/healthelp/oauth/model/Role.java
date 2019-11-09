package com.healthelp.oauth.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Data
@Builder
public class Role implements Serializable {
    private Long id;
    private String role;
    public Role(){}

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }
}
