package com.healthelp.users.controller.impl;

import com.healthelp.users.model.ErrorMessages;
import com.healthelp.users.model.dto.HttpErrorDTO;
import com.healthelp.users.model.exceptions.HandleExceptionFindUserName;
import com.healthelp.users.model.exceptions.HandleExceptionGetUsers;
import com.healthelp.users.model.map.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerControllerImpl extends ResponseEntityExceptionHandler {

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Assert.state(requestAttributes != null, "Could not find current request via RequestContextHolder");
        Assert.isInstanceOf(ServletRequestAttributes.class, requestAttributes);
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        Assert.state(servletRequest != null, "Could not find current HttpServletRequest");
        return servletRequest;
    }

    @ExceptionHandler(HandleExceptionFindUserName.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionFindUserName(Exception ex) {
        log.error(" -- ERROR HEALTHELP: User not found {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return UserMapper.buildHttpErrorDTO(ErrorMessages.ERROR_GET_FIND_BY_USERNAME.getCode(), HttpStatus.NOT_FOUND,
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_GET_FIND_BY_USERNAME.getMessage(),getCurrentRequest().getMethod(),new Date());
    }

    @ExceptionHandler(HandleExceptionGetUsers.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionGetUsers(Exception ex){
        log.error(" -- ERROR HEALTHELP: Users not found {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return UserMapper.buildHttpErrorDTO(ErrorMessages.ERROR_GET_USERS.getCode(),HttpStatus.FORBIDDEN,
                getCurrentRequest().getServletPath(),ErrorMessages.ERROR_GET_USERS.getMessage(),getCurrentRequest().getMethod(),new Date());
    }
}

