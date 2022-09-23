package com.krystiankrawczyk.portfolio.creator;

import com.krystiankrawczyk.portfolio.api.request.PostSendMessageRequest;
import com.krystiankrawczyk.portfolio.db.EntryLogDb;
import com.krystiankrawczyk.portfolio.db.SentMessageDb;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.repository.SentMessageRepository;
import com.krystiankrawczyk.portfolio.sender.MailMessageSender;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

@Component
public class SentMessageCreator {

    private final SentMessageRepository repository;
    private final MailMessageSender mailMessageSender;

    public SentMessageCreator(SentMessageRepository repository, MailMessageSender mailMessageSender) {
        this.repository = repository;
        this.mailMessageSender = mailMessageSender;
    }

    public void createMessage(PostSendMessageRequest request, Long visitId) {
        mailMessageSender.sendMail(request);
        repository.save(new SentMessageDb()
                .setMessage(request.getMessage())
                .setEmail(request.getSenderEmail())
                .setName(request.getSenderName())
                .setEntryLogDb(new EntryLogDb().setId(visitId))
        );
    }
}
