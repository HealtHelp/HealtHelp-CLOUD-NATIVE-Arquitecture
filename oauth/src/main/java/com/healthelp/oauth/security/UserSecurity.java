package com.healthelp.oauth.security;

import com.healthelp.oauth.model.UserDTO;

public interface UserSecurity {

    UserDTO findByUserName(String username);
}
