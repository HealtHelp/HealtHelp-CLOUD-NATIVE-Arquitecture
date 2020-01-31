package com.healthelp.oauth.model;



import java.util.List;


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

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public List<Role> getRoleList() {
        return roleList;
    }
}
