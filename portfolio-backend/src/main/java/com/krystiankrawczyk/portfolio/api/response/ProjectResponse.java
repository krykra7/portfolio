package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectResponse {

    private final String github;
    private final String demo;
    private final Long imageId;
    private final String title;
    private final String description;

    public ProjectResponse(
            @JsonProperty("github") String github,
            @JsonProperty("demo") String demo,
            @JsonProperty("imageId") Long imageId,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description) {
        this.github = github;
        this.demo = demo;
        this.imageId = imageId;
        this.title = title;
        this.description = description;
    }

    public String getGithub() {
        return github;
    }

    public String getDemo() {
        return demo;
    }

    public Long getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
