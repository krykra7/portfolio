package com.krystiankrawczyk.portfolio.provider.mapper;

import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponse;
import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponseBuilder;
import com.krystiankrawczyk.portfolio.db.SummaryDb;

import org.springframework.stereotype.Component;

@Component
public class SummaryResponseMapper {

    private final ServiceGroupsMapper serviceGroupsMapper;
    private final SkillGroupsMapper skillGroupsMapper;
    private final ProjectsMapper projectsMapper;

    public SummaryResponseMapper(ServiceGroupsMapper serviceGroupsMapper,
                                 SkillGroupsMapper skillGroupsMapper,
                                 ProjectsMapper projectsMapper) {
        this.serviceGroupsMapper = serviceGroupsMapper;
        this.skillGroupsMapper = skillGroupsMapper;
        this.projectsMapper = projectsMapper;
    }

    public GetSummaryResponse map(SummaryDb summaryDb) {
        return new GetSummaryResponseBuilder()
                .withClientsSummary(summaryDb.getClientsSummary())
                .withExperienceSummary(summaryDb.getExperienceSummary())
                .withProjectsSummary(summaryDb.getProjectsSummary())
                .withAbout(summaryDb.getAbout())
                .withServiceGroups(serviceGroupsMapper.map(summaryDb.getServices()))
                .withSkillGroups(skillGroupsMapper.map(summaryDb.getSkillGroups()))
                .withProjects(projectsMapper.map(summaryDb.getProjects()))
                .build();
    }

}
