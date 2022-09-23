package com.krystiankrawczyk.portfolio.provider.mapper;

import com.krystiankrawczyk.portfolio.api.response.SkillResponse;
import com.krystiankrawczyk.portfolio.db.SkillDb;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillsMapper {

    public List<SkillResponse> map(List<SkillDb> skills) {
        return skills
                .stream()
                .map(this::mapItem)
                .collect(Collectors.toList());
    }

    private SkillResponse mapItem(SkillDb skill) {
        return new SkillResponse(skill.getName(), skill.getLevel().getLabel());
    }
}
