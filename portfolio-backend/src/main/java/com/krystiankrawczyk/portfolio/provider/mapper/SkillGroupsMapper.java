package com.krystiankrawczyk.portfolio.provider.mapper;

import com.krystiankrawczyk.portfolio.api.response.SkillGroupResponse;
import com.krystiankrawczyk.portfolio.db.SkillGroupDb;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillGroupsMapper {

    private final SkillsMapper skillsMapper;

    public SkillGroupsMapper(SkillsMapper skillsMapper) {
        this.skillsMapper = skillsMapper;
    }

    public List<SkillGroupResponse> map(List<SkillGroupDb> skillGroupDbs) {
        return skillGroupDbs
                .stream()
                .map(this::mapItem)
                .collect(Collectors.toList());
    }

    private SkillGroupResponse mapItem(SkillGroupDb skillGroupDb) {
        return new SkillGroupResponse(skillGroupDb.getCategory().getLabel(), skillsMapper.map(skillGroupDb.getSkills()));
    }
}
