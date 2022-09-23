package com.krystiankrawczyk.portfolio.api.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PostSendMessageRequest {

    private final String senderName;
    private final String message;
    private final String senderEmail;

    public PostSendMessageRequest(
            @JsonProperty("senderName") String senderName,
            @JsonProperty("message") String message,
            @JsonProperty("senderEmail") String senderEmail) {
        this.senderName = senderName;
        this.message = message;
        this.senderEmail = senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}
