package com.krystiankrawczyk.portfolio.exception;

import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.exception.message.MessageProvider;

public class AppException extends RuntimeException {

    private final ApiMessageCode errorMessage;

    public AppException(ApiMessageCode errorMessage) {
        super(MessageProvider.getMessage(errorMessage));
        this.errorMessage = errorMessage;
    }

    public AppException(ApiMessageCode errorMessage, Throwable cause) {
        super(MessageProvider.getMessage(errorMessage), cause);
        this.errorMessage = errorMessage;
    }

    public ApiMessageCode getErrorMessage() {
        return errorMessage;
    }
}
