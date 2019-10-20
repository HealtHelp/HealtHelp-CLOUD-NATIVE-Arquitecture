package com.healthelp.billing.model.dto;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@Builder
public class BillingDTO  {
    private Integer id;
    private Date date;
    private Integer patientId;
    private Integer sessionId;
    private Integer amount;
}
