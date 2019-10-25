package com.healthelp.billing.model;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    ERROR_GET_BILLINGS_BY_PATIENT_ID(204,"Ninguna facturación coincide con el id del paciente","GET /billings/");

    private Integer code;
    private String message;
    private String url;

     ErrorMessages(Integer code,String message,String url){
        this.code = code;
        this.message = message;
        this.url = url;
    }
}
