package com.krystiankrawczyk.portfolio.provider.mapper;

import com.krystiankrawczyk.portfolio.api.response.ProjectResponse;
import com.krystiankrawczyk.portfolio.api.response.ProjectResponseBuilder;
import com.krystiankrawczyk.portfolio.db.ProjectDb;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectsMapper {

    public List<ProjectResponse> map(List<ProjectDb> projectDbs) {
        return projectDbs
                .stream()
                .map(this::mapItem)
                .collect(Collectors.toList());
    }

    private ProjectResponse mapItem(ProjectDb projectDb) {
        return new ProjectResponseBuilder()
                .withDemo(projectDb.getDemo())
                .withImageId(projectDb.getImage().getId())
                .withGithub(projectDb.getGithub())
                .withTitle(projectDb.getTitle())
                .withDescription(projectDb.getDescription())
                .build();
    }
}
