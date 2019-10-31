package com.healthelp.users.service;

import com.healthelp.users.model.dto.UserDTO;

public interface UserService {
    UserDTO findByUsername(String username);
}
