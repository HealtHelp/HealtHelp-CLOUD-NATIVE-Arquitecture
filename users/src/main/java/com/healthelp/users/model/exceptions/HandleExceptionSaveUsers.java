package com.healthelp.users.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandleExceptionSaveUsers extends Throwable {
    public HandleExceptionSaveUsers(Exception ex) {
        super(ex.getMessage());
    }
}

