package com.krystiankrawczyk.portfolio.controller.put;

import com.krystiankrawczyk.portfolio.creator.EntryCookieCreator;
import com.krystiankrawczyk.portfolio.updater.EntryLogUpdater;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/log")
public class PutEntryLogController {

    private final EntryLogUpdater entryLogUpdater;
    private final EntryCookieCreator entryCookieCreator;

    public PutEntryLogController(EntryLogUpdater entryLogUpdater, EntryCookieCreator entryCookieCreator) {
        this.entryLogUpdater = entryLogUpdater;
        this.entryCookieCreator = entryCookieCreator;
    }

    @PutMapping("/entry")
    public ResponseEntity<Void> updateEntryLog(@CookieValue(name = "visit-id") Long visitId) {
        entryLogUpdater.updateLeaveDate(visitId);
        ResponseCookie cookie = entryCookieCreator.createDeactivatedCookie(visitId);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}
