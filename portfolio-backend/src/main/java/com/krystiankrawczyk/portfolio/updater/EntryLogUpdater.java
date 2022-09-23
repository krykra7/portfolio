package com.krystiankrawczyk.portfolio.updater;

import com.krystiankrawczyk.portfolio.db.EntryLogDb;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.repository.EntryLogRepository;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

@Component
public class EntryLogUpdater {

    private final EntryLogRepository entryLogRepository;

    public EntryLogUpdater(EntryLogRepository entryLogRepository) {
        this.entryLogRepository = entryLogRepository;
    }

    @Transactional
    public void updateLeaveDate(Long entryId) {
        EntryLogDb entry = entryLogRepository
                .findById(entryId)
                .orElseThrow(() -> new AppException(ApiMessageCode.ENTRY_NOT_FOUND));

        entry.setLeaveDate(LocalDateTime.now());
        entryLogRepository.save(entry);
    }
}
