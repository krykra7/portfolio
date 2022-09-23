package com.krystiankrawczyk.portfolio.creator;

import com.krystiankrawczyk.portfolio.api.request.PostSocialLogRequest;
import com.krystiankrawczyk.portfolio.db.EntryLogDb;
import com.krystiankrawczyk.portfolio.db.SocialLogDb;
import com.krystiankrawczyk.portfolio.repository.SocialLogRepository;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SocialLogCreator {

    private final SocialLogRepository repository;

    public SocialLogCreator(SocialLogRepository repository) {
        this.repository = repository;
    }

    public Long createSocialLog(PostSocialLogRequest request, Long visitId) {
        return repository.save(
                new SocialLogDb()
                        .setEntryLogDb(new EntryLogDb().setId(visitId))
                        .setLinkType(request.getLinkType())
                        .setLinkValue(request.getLinkValue())
                        .setAccessDate(LocalDateTime.now())
        ).getId();
    }
}
