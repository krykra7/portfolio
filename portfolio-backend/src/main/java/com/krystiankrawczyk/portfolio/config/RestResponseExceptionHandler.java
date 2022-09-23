package com.krystiankrawczyk.portfolio.config;

import com.krystiankrawczyk.portfolio.api.response.ErrorResponse;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppException.class)
    private ResponseEntity<ErrorResponse> handleExceptions(AppException e) {
        e.printStackTrace();
        ApiMessageCode errorMessage = e.getErrorMessage();
        return ResponseEntity.status(errorMessage.getCode()).body(new ErrorResponse(e.getMessage()));
    }
}
