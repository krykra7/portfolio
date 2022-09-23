package com.krystiankrawczyk.portfolio.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project", schema = "portfolio")
public class ProjectDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "github")
    private String github;

    @Column(name = "demo")
    private String demo;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private FileDb image;

    public long getId() {
        return id;
    }

    public ProjectDb setId(long id) {
        this.id = id;
        return this;
    }

    public String getGithub() {
        return github;
    }

    public ProjectDb setGithub(String github) {
        this.github = github;
        return this;
    }

    public String getDemo() {
        return demo;
    }

    public ProjectDb setDemo(String demo) {
        this.demo = demo;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProjectDb setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectDb setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectDb setImage(FileDb image) {
        this.image = image;
        return this;
    }

    public FileDb getImage() {
        return image;
    }
}
