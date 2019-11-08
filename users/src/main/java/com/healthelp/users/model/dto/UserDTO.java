package com.healthelp.users.model.dto;

import com.healthelp.users.model.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

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
}
