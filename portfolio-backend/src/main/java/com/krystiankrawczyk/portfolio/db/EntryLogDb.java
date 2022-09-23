package com.krystiankrawczyk.portfolio.db;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry_log", schema = "portfolio")
public class EntryLogDb {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "enter_date")
    private LocalDateTime enterDate;

    @Column(name = "leave_date")
    private LocalDateTime leaveDate;

    public long getId() {
        return id;
    }

    public EntryLogDb setId(long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getEnterDate() {
        return enterDate;
    }

    public EntryLogDb setEnterDate(LocalDateTime enterDate) {
        this.enterDate = enterDate;
        return this;
    }

    public LocalDateTime getLeaveDate() {
        return leaveDate;
    }

    public EntryLogDb setLeaveDate(LocalDateTime leaveDate) {
        this.leaveDate = leaveDate;
        return this;
    }
}
