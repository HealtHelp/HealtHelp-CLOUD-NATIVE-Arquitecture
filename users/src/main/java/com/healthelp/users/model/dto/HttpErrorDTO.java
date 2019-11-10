package com.healthelp.users.model.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Data
@Builder
public class HttpErrorDTO {
    private Integer code;
    private String statusText;
    private String url;
    private String message;
    private String method;
    private String date;
}
