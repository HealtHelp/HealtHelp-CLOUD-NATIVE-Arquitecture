package com.healthelp.users.model;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ERROR_GET_FIND_BY_USERNAME(201,"Ningún usuario coincide con el nombre solicitado.");

    private Integer code;
    private String message;


    ErrorMessages(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
