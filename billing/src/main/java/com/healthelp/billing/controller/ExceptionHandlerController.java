package com.healthelp.billing.controller;

import com.healthelp.billing.model.dto.HttpErrorDTO;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;


public interface ExceptionHandlerController {

    ResponseEntity<HttpErrorDTO> handleNotFoundByPatientId(Exception ex, HttpServletRequest request);
}
