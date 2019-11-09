package com.healthelp.oauth.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
@Builder
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private Integer tenantId;
    private String email;
    private Boolean enabled;
    private List<Role> roleList;

    public UserDTO(){}
    public UserDTO(Integer id, String username, String password, Integer tenantId, String email, Boolean enabled, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tenantId = tenantId;
        this.email = email;
        this.enabled = enabled;
        this.roleList = roleList;
    }
}
