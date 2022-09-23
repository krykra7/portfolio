package com.krystiankrawczyk.portfolio.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sent_message", schema = "portfolio")
public class SentMessageDb {

     @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entry_id")
    private EntryLogDb entryLogDb;

    public long getId() {
        return id;
    }

    public SentMessageDb setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SentMessageDb setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SentMessageDb setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SentMessageDb setMessage(String message) {
        this.message = message;
        return this;
    }

    public EntryLogDb getEntryLogDb() {
        return entryLogDb;
    }

    public SentMessageDb setEntryLogDb(EntryLogDb entryLogDb) {
        this.entryLogDb = entryLogDb;
        return this;
    }
}
