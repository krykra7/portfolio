package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResponse {

    private final String name;

    public ServiceResponse(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
