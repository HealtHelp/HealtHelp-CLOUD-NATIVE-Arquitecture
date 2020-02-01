package com.healthelp.users.service;

import com.healthelp.users.model.dto.UserDTO;
import com.healthelp.users.model.entity.User;
import com.healthelp.users.model.exceptions.HandleExceptionSaveUsers;
import com.healthelp.users.service.dummy.UserServiceDummy;
import com.healthelp.users.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestImpl {
    private UserService userService = Mockito.mock(UserService.class);
    private UserServiceImpl userServiceImpl = Mockito.mock(UserServiceImpl.class);


    @Test
    void findByUsernameTestEmpty(){
        //save user ""Bladimir"
        UserDTO user = userService.findByUsername("Bladimir");
        given(userService.findByUsername(any())).willReturn(user);
        UserDTO userDTO2 = userServiceImpl.findByUsername("Bladimir");
        assert (user==null);
        assert (userDTO2==null);
    }

    @Test
    void getUsersAll(){
        PageRequest pageable = UserServiceDummy.pageRequestDummy();
        List<UserDTO> userDTOS = userService.getUsers(pageable);
        given(userService.getUsers(any())).willReturn(userDTOS);
        List<UserDTO> userDTOS1 =  userServiceImpl.getUsers(pageable);
        assert (userDTOS.size()==userDTOS1.size());
    }

    @Test
    void saveUserAll() throws HandleExceptionSaveUsers {
        User user = UserServiceDummy.userDummy();
        UserDTO userDTO = userService.saveUser(user);
        given(userService.saveUser(any())).willReturn(userDTO);
        UserDTO userDTO1 = userServiceImpl.saveUser(user);
        assert (userDTO==null||userDTO1==null);
    }
}
