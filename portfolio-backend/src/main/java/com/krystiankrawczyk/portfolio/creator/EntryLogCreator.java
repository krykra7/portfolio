package com.krystiankrawczyk.portfolio.creator;

import com.krystiankrawczyk.portfolio.db.EntryLogDb;
import com.krystiankrawczyk.portfolio.repository.EntryLogRepository;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntryLogCreator {

    private final EntryLogRepository repository;

    public EntryLogCreator(EntryLogRepository repository) {
        this.repository = repository;
    }

    public Long createEntryLog() {
        return repository.save(new EntryLogDb().setEnterDate(LocalDateTime.now())).getId();
    }
}
