package com.krystiankrawczyk.portfolio.controller.post;

import com.krystiankrawczyk.portfolio.api.request.PostSendMessageRequest;
import com.krystiankrawczyk.portfolio.creator.SentMessageCreator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PostSendMessageController {

    private final SentMessageCreator messageCreator;

    public PostSendMessageController(SentMessageCreator messageCreator) {
        this.messageCreator = messageCreator;
    }

    @PostMapping("/message")
    public ResponseEntity<Void> sendMessage(@RequestBody PostSendMessageRequest request,
                                            @CookieValue(name = "visit-id") Long visitId) {
        messageCreator.createMessage(request, visitId);
        return ResponseEntity.ok().build();
    }
}
