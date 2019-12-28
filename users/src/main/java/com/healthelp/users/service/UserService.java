package com.healthelp.users.service;

import com.healthelp.users.model.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDTO findByUsername(String username);
    List<UserDTO> getUsers(Pageable pageable);
}
