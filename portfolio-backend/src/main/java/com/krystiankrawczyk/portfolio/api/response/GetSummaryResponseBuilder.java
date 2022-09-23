package com.krystiankrawczyk.portfolio.api.response;

import java.util.List;

public final class GetSummaryResponseBuilder {
    private String about;
    private String experienceSummary;
    private String clientsSummary;
    private String projectsSummary;
    private List<ProjectResponse> projects;
    private List<SkillGroupResponse> skillGroups;
    private List<ServiceGroupResponse> serviceGroups;

    public GetSummaryResponseBuilder withAbout(String about) {
        this.about = about;
        return this;
    }

    public GetSummaryResponseBuilder withExperienceSummary(String experienceSummary) {
        this.experienceSummary = experienceSummary;
        return this;
    }

    public GetSummaryResponseBuilder withClientsSummary(String clientsSummary) {
        this.clientsSummary = clientsSummary;
        return this;
    }

    public GetSummaryResponseBuilder withProjectsSummary(String projectsSummary) {
        this.projectsSummary = projectsSummary;
        return this;
    }

    public GetSummaryResponseBuilder withProjects(List<ProjectResponse> projects) {
        this.projects = projects;
        return this;
    }

    public GetSummaryResponseBuilder withSkillGroups(List<SkillGroupResponse> skillGroups) {
        this.skillGroups = skillGroups;
        return this;
    }

    public GetSummaryResponseBuilder withServiceGroups(List<ServiceGroupResponse> serviceGroups) {
        this.serviceGroups = serviceGroups;
        return this;
    }

    public GetSummaryResponse build() {
        return new GetSummaryResponse(about, experienceSummary, clientsSummary, projectsSummary, projects, skillGroups,
                serviceGroups);
    }
}
