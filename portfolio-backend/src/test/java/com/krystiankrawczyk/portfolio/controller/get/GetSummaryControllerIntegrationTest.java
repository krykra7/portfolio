package com.krystiankrawczyk.portfolio.controller.get;

import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponse;
import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponseBuilder;
import com.krystiankrawczyk.portfolio.api.response.ProjectResponse;
import com.krystiankrawczyk.portfolio.api.response.ProjectResponseBuilder;
import com.krystiankrawczyk.portfolio.api.response.ServiceGroupResponse;
import com.krystiankrawczyk.portfolio.api.response.ServiceResponse;
import com.krystiankrawczyk.portfolio.api.response.SkillGroupResponse;
import com.krystiankrawczyk.portfolio.api.response.SkillResponse;
import com.krystiankrawczyk.portfolio.common.RestTestHelper;
import com.krystiankrawczyk.portfolio.db.ProjectDb;
import com.krystiankrawczyk.portfolio.db.ServiceGroupDb;
import com.krystiankrawczyk.portfolio.db.SkillGroupDb;
import com.krystiankrawczyk.portfolio.db.SummaryDb;
import com.krystiankrawczyk.portfolio.repository.SummaryRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class GetSummaryControllerIntegrationTest {

    @Autowired
    private RestTestHelper restTestHelper;

    @Autowired
    private SummaryRepository summaryRepository;

    @Test
    void shouldReturnSummary() {
        //    Given
        GetSummaryResponse expected = prepareExpected();
        //    When
        ResponseEntity<GetSummaryResponse> response = restTestHelper
                .getRequest("/api/v1/summary", GetSummaryResponse.class)
                .send();
        //    Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getAbout()).isEqualTo(expected.getAbout());
        assertThat(response.getBody().getClientsSummary()).isEqualTo(expected.getClientsSummary());
        assertThat(response.getBody().getProjectsSummary()).isEqualTo(expected.getProjectsSummary());
        assertThat(response.getBody().getExperienceSummary()).isEqualTo(expected.getExperienceSummary());
        assertThat(response.getBody().getProjects())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(expected.getProjects());
        assertThat(response.getBody().getSkillGroups())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(expected.getSkillGroups());
        assertThat(response.getBody().getServiceGroups())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(expected.getServiceGroups());
    }

    private List<ProjectResponse> mapProjects(List<ProjectDb> projectDbs) {
        return projectDbs
                .stream()
                .map(projectDb -> new ProjectResponseBuilder()
                        .withDemo(projectDb.getDemo())
                        .withImageId(projectDb.getImage().getId())
                        .withGithub(projectDb.getGithub())
                        .withTitle(projectDb.getTitle())
                        .withDescription(projectDb.getDescription())
                        .build()
                ).collect(Collectors.toList());
    }

    private List<ServiceGroupResponse> mapServiceGroups(List<ServiceGroupDb> serviceGroupDbs) {
        return serviceGroupDbs
                .stream()
                .map(serviceGroupDb -> new ServiceGroupResponse(
                        serviceGroupDb.getTitle(),
                        serviceGroupDb.getServices()
                                .stream()
                                .map(serviceDb -> new ServiceResponse(serviceDb.getName()))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }

    private List<SkillGroupResponse> mapSkillGroups(List<SkillGroupDb> skillGroupDbs) {
        return skillGroupDbs
                .stream()
                .map(skillGroupDb -> new SkillGroupResponse(
                        skillGroupDb.getCategory().getLabel(),
                        skillGroupDb.getSkills()
                                .stream()
                                .map(skillDb -> new SkillResponse(skillDb.getName(), skillDb.getLevel().getLabel()))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }

    public GetSummaryResponse prepareExpected() {
        SummaryDb summaryDb = summaryRepository.findLatest().get();

        return new GetSummaryResponseBuilder()
                .withAbout(summaryDb.getAbout())
                .withClientsSummary(summaryDb.getClientsSummary())
                .withProjectsSummary(summaryDb.getProjectsSummary())
                .withExperienceSummary(summaryDb.getExperienceSummary())
                .withProjects(mapProjects(summaryDb.getProjects()))
                .withSkillGroups(mapSkillGroups(summaryDb.getSkillGroups()))
                .withServiceGroups(mapServiceGroups(summaryDb.getServices()))
                .build();
    }
}
