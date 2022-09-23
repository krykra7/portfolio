package com.krystiankrawczyk.portfolio.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service", schema = "portfolio")
public class ServiceDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public ServiceDb setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServiceDb setName(String name) {
        this.name = name;
        return this;
    }
}
