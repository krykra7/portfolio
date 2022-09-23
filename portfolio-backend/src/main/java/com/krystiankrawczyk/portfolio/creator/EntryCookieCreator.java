package com.krystiankrawczyk.portfolio.creator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class EntryCookieCreator {

    private static final String COOKIE_PATH = "/";
    private static final String COOKIE_NAME = "visit-id";

    @Value("${cookie.domain}")
    private String domain;

    public ResponseCookie createActiveCookie(Long entryId) {
        return ResponseCookie.from(COOKIE_NAME, entryId.toString())
                .path(COOKIE_PATH)
                .domain(domain)
                .httpOnly(true)
                .secure(true)
                .build();
    }

    public ResponseCookie createDeactivatedCookie(Long entryId) {
        return ResponseCookie
                .from(COOKIE_NAME, entryId.toString())
                .maxAge(0)
                .build();
    }
}
