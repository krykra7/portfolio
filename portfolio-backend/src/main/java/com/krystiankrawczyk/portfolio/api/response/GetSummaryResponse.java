package com.krystiankrawczyk.portfolio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetSummaryResponse {

    private final String about;
    private final String experienceSummary;
    private final String clientsSummary;
    private final String projectsSummary;
    private final List<ProjectResponse> projects;
    private final List<SkillGroupResponse> skillGroups;
    private final List<ServiceGroupResponse> serviceGroups;

    public GetSummaryResponse(@JsonProperty("about") String about,
                              @JsonProperty("experienceSummary") String experienceSummary,
                              @JsonProperty("clientsSummary") String clientsSummary,
                              @JsonProperty("projectsSummary") String projectsSummary,
                              @JsonProperty("projects") List<ProjectResponse> projects,
                              @JsonProperty("skillGroups") List<SkillGroupResponse> skillGroups,
                              @JsonProperty("serviceGroups") List<ServiceGroupResponse> serviceGroups) {
        this.about = about;
        this.experienceSummary = experienceSummary;
        this.clientsSummary = clientsSummary;
        this.projectsSummary = projectsSummary;
        this.projects = projects;
        this.skillGroups = skillGroups;
        this.serviceGroups = serviceGroups;
    }

    public String getAbout() {
        return about;
    }

    public String getExperienceSummary() {
        return experienceSummary;
    }

    public String getClientsSummary() {
        return clientsSummary;
    }

    public String getProjectsSummary() {
        return projectsSummary;
    }

    public List<ProjectResponse> getProjects() {
        return projects;
    }

    public List<SkillGroupResponse> getSkillGroups() {
        return skillGroups;
    }

    public List<ServiceGroupResponse> getServiceGroups() {
        return serviceGroups;
    }
}
