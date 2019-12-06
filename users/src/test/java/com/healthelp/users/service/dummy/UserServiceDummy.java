package com.healthelp.users.service.dummy;

import com.healthelp.users.model.entity.Role;
import com.healthelp.users.model.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserServiceDummy {
    public static User userDummy(){
        return User.builder()
                .id(1)
                .username("Bladimir")
                .email("bladidb@gmail.com")
                .tenantId(1)
                .enabled(true)
                .password("$2a$10$9IZmZcS9Npz8MUSBS.KLguHOQJsS0jr6SqHKHysmQ4LypYKtjQ5w.")
                .roleList(dummyRoles())
                .build();
    }

    private static List<Role> dummyRoles() {
        return Arrays.asList(
                new Role(1L,"ADMIN"),
                new Role(2L,"USER")
        );
    }
}
