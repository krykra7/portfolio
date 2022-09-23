package com.krystiankrawczyk.portfolio.db;

import com.krystiankrawczyk.portfolio.db.enums.Level;
import com.krystiankrawczyk.portfolio.db.enums.SkillsCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill", schema = "portfolio")
public class SkillDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    public long getId() {
        return id;
    }

    public SkillDb setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SkillDb setName(String name) {
        this.name = name;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public SkillDb setLevel(Level level) {
        this.level = level;
        return this;
    }
}
