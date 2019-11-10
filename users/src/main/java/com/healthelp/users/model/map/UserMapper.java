package com.healthelp.users.model.map;

import com.healthelp.users.model.dto.HttpErrorDTO;
import com.healthelp.users.model.entity.User;
import com.healthelp.users.model.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

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

    public static ResponseEntity<HttpErrorDTO> buildHttpErrorDTO(Integer code, HttpStatus statusText, String url, String message, String method, Date date) {
        return new ResponseEntity<>(HttpErrorDTO.builder()
                .code(code)
                .statusText(statusText.toString())
                .url(url)
                .message(message)
                .method(method)
                .date(date.toString())
                .build(), HttpStatus.NOT_FOUND);
    }
}
