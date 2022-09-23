package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.krystiankrawczyk.portfolio.db.enums.Level;

public class SkillResponse {

    private final String name;
    private final String level;

    public SkillResponse(
            @JsonProperty("name") String name,
            @JsonProperty("level") String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
