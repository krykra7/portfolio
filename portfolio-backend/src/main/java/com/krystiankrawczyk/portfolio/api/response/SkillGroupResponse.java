package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.krystiankrawczyk.portfolio.db.enums.SkillsCategory;

import org.springframework.data.web.JsonPath;

import java.util.List;

public class SkillGroupResponse {

    private final String category;
    private final List<SkillResponse> skills;

    public SkillGroupResponse(
            @JsonProperty("category") String category,
            @JsonProperty("skills") List<SkillResponse> skills) {
        this.category = category;
        this.skills = skills;
    }

    public String getCategory() {
        return category;
    }

    public List<SkillResponse> getSkills() {
        return skills;
    }
}
