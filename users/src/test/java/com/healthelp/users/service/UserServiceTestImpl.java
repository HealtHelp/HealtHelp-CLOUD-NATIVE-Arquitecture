package com.healthelp.users.service;

import com.healthelp.users.model.dto.UserDTO;
import com.healthelp.users.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestImpl {
    private UserService userService = Mockito.mock(UserService.class);
    private UserServiceImpl userServiceImpl = Mockito.mock(UserServiceImpl.class);

    @Test
    void findByUsernameTestEmpty(){
        UserDTO user = userService.findByUsername("Bladimir");
        given(userService.findByUsername(any())).willReturn(user);
        UserDTO userDTO2 = userServiceImpl.findByUsername("Bladimir");
        assert (user==null);
        assert (userDTO2==null);
    }
}
