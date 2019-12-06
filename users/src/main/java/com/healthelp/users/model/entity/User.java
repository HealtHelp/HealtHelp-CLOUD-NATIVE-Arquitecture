package com.healthelp.users.model.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.List;



@Data
@Builder
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "tenant_id")
    private Integer tenantId;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "roles")

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"),
               uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<Role> roleList;

    public User(){

    }

    public User(Integer id,String username, String password, Integer tenantId, String email, Boolean enabled, List<Role> roleList) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.tenantId = tenantId;
        this.email = email;
        this.enabled = enabled;
        this.roleList = roleList;
    }

}
