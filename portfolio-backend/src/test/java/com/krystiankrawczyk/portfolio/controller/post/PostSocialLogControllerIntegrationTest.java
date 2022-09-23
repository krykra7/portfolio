package com.krystiankrawczyk.portfolio.controller.post;

import com.krystiankrawczyk.portfolio.api.request.PostSocialLogRequest;
import com.krystiankrawczyk.portfolio.common.RestTestHelper;
import com.krystiankrawczyk.portfolio.db.EntryLogDb;
import com.krystiankrawczyk.portfolio.db.SocialLogDb;
import com.krystiankrawczyk.portfolio.db.enums.LinkType;
import com.krystiankrawczyk.portfolio.repository.EntryLogRepository;
import com.krystiankrawczyk.portfolio.repository.SocialLogRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class PostSocialLogControllerIntegrationTest {

    private static final String LINK_VALUE = "LinkValue";

    @Autowired
    private RestTestHelper restTestHelper;

    @Autowired
    private SocialLogRepository socialLogRepository;

    @Autowired
    private EntryLogRepository entryLogRepository;

    @Test
    void shouldCreateSocialLog() {
        // Given
        LocalDateTime entryTime = LocalDateTime.now();
        EntryLogDb entryLogDb = entryLogRepository.save(new EntryLogDb()
                .setEnterDate(entryTime)
                .setLeaveDate(entryTime));
        PostSocialLogRequest request = new PostSocialLogRequest(LinkType.GITHUB, LINK_VALUE);
        // When
        ResponseEntity<Long> response = restTestHelper.postRequest("/api/v1/log/social", Long.class)
                .body(request)
                .cookie("visit-id", String.valueOf(entryLogDb.getId()))
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        SocialLogDb createdLog = socialLogRepository.findAll().get(0);
        assertThat(createdLog.getId()).isEqualTo(response.getBody());
        assertThat(createdLog.getLinkType()).isEqualTo(LinkType.GITHUB);
        assertThat(createdLog.getLinkValue()).isEqualTo(LINK_VALUE);
        assertThat(createdLog.getEntryLogDb().getId()).isEqualTo(entryLogDb.getId());
    }
}
