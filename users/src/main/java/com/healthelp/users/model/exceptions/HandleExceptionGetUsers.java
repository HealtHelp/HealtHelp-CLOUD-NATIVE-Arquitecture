package com.healthelp.users.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandleExceptionGetUsers extends RuntimeException {
    public HandleExceptionGetUsers(Exception ex) {
        super(ex.getMessage());
    }
}
