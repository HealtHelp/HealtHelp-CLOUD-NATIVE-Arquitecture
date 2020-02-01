package com.healthelp.users.service.dummy;

import com.healthelp.users.model.entity.Role;
import com.healthelp.users.model.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
                .password("12345")
                .roleList(dummyRoles())
                .build();
    }

    private static List<Role> dummyRoles() {
        return Arrays.asList(
                new Role(1L,"ADMIN"),
                new Role(2L,"USER")
        );
    }

    public static PageRequest pageRequestDummy(){
        return  PageRequest.of(0, 5, Sort.Direction.DESC, "username");
    }
}
