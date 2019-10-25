package com.healthelp.billing.controller.impl;

import com.healthelp.billing.model.ErrorMessages;
import com.healthelp.billing.model.dto.HttpErrorDTO;
import com.healthelp.billing.model.exceptions.HandleNotFoundByPatientId;
import com.healthelp.billing.model.map.BillingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@ControllerAdvice
public class ExceptionHandlerControllerImpl extends ResponseEntityExceptionHandler  {

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Assert.state(requestAttributes != null, "Could not find current request via RequestContextHolder");
        Assert.isInstanceOf(ServletRequestAttributes.class, requestAttributes);
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        Assert.state(servletRequest != null, "Could not find current HttpServletRequest");
        return servletRequest;
    }


    @ExceptionHandler(HandleNotFoundByPatientId.class)
    public ResponseEntity<HttpErrorDTO> handleNotFoundByPatientId(Exception ex) {
        log.error(" -- ERROR: Billing not found {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                 getCurrentRequest().getRequestURI());
        return BillingMapper.buildHttpErrorDTO(ErrorMessages.ERROR_GET_BILLINGS_BY_PATIENT_ID.getCode(),ex.getMessage(),
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_GET_BILLINGS_BY_PATIENT_ID.getMessage());
    }
}
