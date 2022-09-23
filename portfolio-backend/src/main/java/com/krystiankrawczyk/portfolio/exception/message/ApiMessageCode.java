package com.krystiankrawczyk.portfolio.exception.message;

import org.springframework.http.HttpStatus;

public enum ApiMessageCode {
    FAILED_TO_FIND_FILE_DB(HttpStatus.NOT_FOUND),
    FAILED_TO_FIND_FILE(HttpStatus.NOT_FOUND),
    ENTRY_NOT_FOUND(HttpStatus.NOT_FOUND),
    SUMMARY_DATA_NOT_FOUND(HttpStatus.NOT_FOUND),
    WRONG_MEDIA_TYPE(HttpStatus.INTERNAL_SERVER_ERROR),
    FILENAME_DOES_NOT_EXIST(HttpStatus.NOT_FOUND),
    MAIL_FAILED(HttpStatus.INTERNAL_SERVER_ERROR)
    ;

    private final HttpStatus code;

    ApiMessageCode(HttpStatus httpStatus) {
        this.code = httpStatus;
    }

    public HttpStatus getCode() {
        return code;
    }
}
