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
@Table(name = "service_group", schema = "portfolio")
public class ServiceGroupDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "service_group_id", referencedColumnName = "id")
    private List<ServiceDb> services;

    public long getId() {
        return id;
    }

    public ServiceGroupDb setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ServiceGroupDb setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<ServiceDb> getServices() {
        return services;
    }

    public ServiceGroupDb setServices(List<ServiceDb> serviceDbs) {
        this.services = serviceDbs;
        return this;
    }
}
