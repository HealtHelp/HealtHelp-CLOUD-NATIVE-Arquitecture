package com.healthelp.billing.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Builder
public class HttpErrorDTO {
    private Integer code;
    private String statusText;
    private String url;
    private String message;
}
