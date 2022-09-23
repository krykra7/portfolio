package com.krystiankrawczyk.portfolio.db;

import com.krystiankrawczyk.portfolio.db.enums.SkillsCategory;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill_group", schema = "portfolio")
public class SkillGroupDb {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private SkillsCategory category;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_group_id", referencedColumnName = "id")
    private List<SkillDb> skills;

    public long getId() {
        return id;
    }

    public SkillGroupDb setId(long id) {
        this.id = id;
        return this;
    }

    public SkillsCategory getCategory() {
        return category;
    }

    public SkillGroupDb setCategory(SkillsCategory category) {
        this.category = category;
        return this;
    }

    public List<SkillDb> getSkills() {
        return skills;
    }

    public SkillGroupDb setSkills(List<SkillDb> skills) {
        this.skills = skills;
        return this;
    }
}
