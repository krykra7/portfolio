package com.krystiankrawczyk.portfolio.db;

import com.krystiankrawczyk.portfolio.db.enums.LinkType;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "social_log", schema = "portfolio")
public class SocialLogDb {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "link_type")
    @Enumerated(EnumType.STRING)
    private LinkType linkType;

    @Column(name = "link_value")
    private String linkValue;

    @Column(name = "access_date")
    private LocalDateTime accessDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entry_id")
    private EntryLogDb entryLogDb;

    public long getId() {
        return id;
    }

    public SocialLogDb setId(long id) {
        this.id = id;
        return this;
    }

    public LinkType getLinkType() {
        return linkType;
    }

    public SocialLogDb setLinkType(LinkType linkType) {
        this.linkType = linkType;
        return this;
    }

    public LocalDateTime getAccessDate() {
        return accessDate;
    }

    public SocialLogDb setAccessDate(LocalDateTime accessDate) {
        this.accessDate = accessDate;
        return this;
    }

    public EntryLogDb getEntryLogDb() {
        return entryLogDb;
    }

    public SocialLogDb setEntryLogDb(EntryLogDb entryLogDb) {
        this.entryLogDb = entryLogDb;
        return this;
    }

    public String getLinkValue() {
        return linkValue;
    }

    public SocialLogDb setLinkValue(String linkValue) {
        this.linkValue = linkValue;
        return this;
    }
}
