package com.healthelp.billing.model;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    ERROR_GET_BILLINGS_BY_PATIENT_ID(204,"Ninguna facturación coincide con el id del paciente");

    private Integer code;
    private String message;


     ErrorMessages(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
