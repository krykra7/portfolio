package com.krystiankrawczyk.portfolio.controller.post;

import com.krystiankrawczyk.portfolio.api.request.PostSocialLogRequest;
import com.krystiankrawczyk.portfolio.creator.SocialLogCreator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/log")
public class PostSocialLogController {

    private final SocialLogCreator socialLogCreator;

    public PostSocialLogController(SocialLogCreator socialLogCreator) {
        this.socialLogCreator = socialLogCreator;
    }

    @PostMapping("/social")
    public ResponseEntity<Long> createSocialLog(
            @CookieValue(name = "visit-id") Long visitId,
            @RequestBody PostSocialLogRequest request) {

        return ResponseEntity.ok(socialLogCreator.createSocialLog(request, visitId));
    }
}
