package com.krystiankrawczyk.portfolio.api.response;

public final class ProjectResponseBuilder {
    private String github;
    private String demo;
    private Long imageId;
    private String title;
    private String description;

    public ProjectResponseBuilder withGithub(String github) {
        this.github = github;
        return this;
    }

    public ProjectResponseBuilder withDemo(String demo) {
        this.demo = demo;
        return this;
    }

    public ProjectResponseBuilder withImageId(Long imageId) {
        this.imageId = imageId;
        return this;
    }

    public ProjectResponseBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProjectResponseBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectResponse build() {
        return new ProjectResponse(github, demo, imageId, title, description);
    }
}
