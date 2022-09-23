package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    private final String message;

    public ErrorResponse(@JsonProperty("message") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
