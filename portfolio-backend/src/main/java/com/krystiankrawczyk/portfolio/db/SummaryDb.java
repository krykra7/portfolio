package com.krystiankrawczyk.portfolio.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "summary", schema = "portfolio")
public class SummaryDb {

    public static final String REVISION_COLUMN = "revision";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "revision", unique = true)
    private Integer revision;

    @Column(name = "about")
    private String about;

    @Column(name = "experience_summary")
    private String experienceSummary;

    @Column(name = "clients_summary")
    private String clientsSummary;

    @Column(name = "projects_summary")
    private String projectsSummary;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "summary_id", referencedColumnName = "id")
    private List<ServiceGroupDb> services;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "summary_id", referencedColumnName = "id")
    private List<SkillGroupDb> skillGroups;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "summary_id", referencedColumnName = "id")
    private List<ProjectDb> projects;

    public long getId() {
        return id;
    }

    public SummaryDb setId(long id) {
        this.id = id;
        return this;
    }

    public Integer getRevision() {
        return revision;
    }

    public SummaryDb setRevision(Integer revision) {
        this.revision = revision;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public SummaryDb setAbout(String about) {
        this.about = about;
        return this;
    }

    public String getExperienceSummary() {
        return experienceSummary;
    }

    public SummaryDb setExperienceSummary(String experienceSummary) {
        this.experienceSummary = experienceSummary;
        return this;
    }

    public String getClientsSummary() {
        return clientsSummary;
    }

    public SummaryDb setClientsSummary(String clientsSummary) {
        this.clientsSummary = clientsSummary;
        return this;
    }

    public String getProjectsSummary() {
        return projectsSummary;
    }

    public SummaryDb setProjectsSummary(String projectsSummary) {
        this.projectsSummary = projectsSummary;
        return this;
    }

    public List<ServiceGroupDb> getServices() {
        return services;
    }

    public SummaryDb setServices(List<ServiceGroupDb> services) {
        this.services = services;
        return this;
    }

    public List<SkillGroupDb> getSkillGroups() {
        return skillGroups;
    }

    public SummaryDb setSkillGroups(List<SkillGroupDb> skillGroupDb) {
        this.skillGroups = skillGroupDb;
        return this;
    }

    public List<ProjectDb> getProjects() {
        return projects;
    }

    public SummaryDb setProjects(List<ProjectDb> projectDbs) {
        this.projects = projectDbs;
        return this;
    }
}
