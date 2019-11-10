package com.healthelp.users.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandleExceptionFindUserName extends RuntimeException {
    public HandleExceptionFindUserName(Exception ex) {
        super(ex.getMessage());
    }
}
