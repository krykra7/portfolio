package com.krystiankrawczyk.portfolio.controller.get;

import com.krystiankrawczyk.portfolio.api.response.GetSummaryResponse;
import com.krystiankrawczyk.portfolio.creator.EntryCookieCreator;
import com.krystiankrawczyk.portfolio.creator.EntryLogCreator;
import com.krystiankrawczyk.portfolio.provider.SummaryProvider;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/summary")
public class GetSummaryController {

    private final SummaryProvider summaryProvider;
    private final EntryLogCreator entryLogCreator;
    private final EntryCookieCreator entryCookieCreator;

    public GetSummaryController(SummaryProvider summaryProvider,
                                EntryLogCreator entryLogCreator,
                                EntryCookieCreator entryCookieCreator) {
        this.summaryProvider = summaryProvider;
        this.entryLogCreator = entryLogCreator;
        this.entryCookieCreator = entryCookieCreator;
    }

    @GetMapping
    public ResponseEntity<GetSummaryResponse> getSummary() {
        Long entryId = entryLogCreator.createEntryLog();
        ResponseCookie cookie = entryCookieCreator.createActiveCookie(entryId);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(summaryProvider.getLatestRevision());
    }
}
