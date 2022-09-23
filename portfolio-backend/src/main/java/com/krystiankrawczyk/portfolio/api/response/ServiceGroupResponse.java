package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ServiceGroupResponse {

    private final String title;
    private final List<ServiceResponse> services;

    public ServiceGroupResponse(
            @JsonProperty("title") String title,
            @JsonProperty("services") List<ServiceResponse> services) {
        this.title = title;
        this.services = services;
    }

    public String getTitle() {
        return title;
    }

    public List<ServiceResponse> getServices() {
        return services;
    }
}
