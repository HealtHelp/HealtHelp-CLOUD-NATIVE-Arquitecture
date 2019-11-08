package com.healthelp.users.model.map;

import com.healthelp.users.model.entity.User;
import com.healthelp.users.model.dto.UserDTO;

public class UserMapper {

    public static UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .tenantId(user.getTenantId())
                .roleList(user.getRoleList())
                .enabled(user.getEnabled())
                .build();
    }
}
