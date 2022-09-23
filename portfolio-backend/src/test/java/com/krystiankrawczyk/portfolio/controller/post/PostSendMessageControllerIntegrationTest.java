package com.krystiankrawczyk.portfolio.controller.post;

import com.krystiankrawczyk.portfolio.api.request.PostSendMessageRequest;
import com.krystiankrawczyk.portfolio.common.RestTestHelper;
import com.krystiankrawczyk.portfolio.db.SentMessageDb;
import com.krystiankrawczyk.portfolio.repository.SentMessageRepository;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class PostSendMessageControllerIntegrationTest {

    @Value("${mail.to}")
    private String mailTo;

    @Autowired
    private RestTestHelper restTestHelper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SentMessageRepository messageRepository;

    @Test
    void shouldSendMessage() {
        // Given
        Long visitId = 1L;

        PostSendMessageRequest request = new PostSendMessageRequest(
                "chris",
                "test message",
                "sender@sender.com"
        );

        ArgumentCaptor<SimpleMailMessage> messageArgumentCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        // When
        ResponseEntity<Void> response = restTestHelper.postRequest("/api/v1/message", Void.class)
                .body(request)
                .cookie("visit-id", String.valueOf(visitId))
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(javaMailSender, times(1)).send(messageArgumentCaptor.capture());
        SimpleMailMessage message = messageArgumentCaptor.getValue();

        assertThat(message.getFrom()).isEqualTo(request.getSenderEmail());
        assertThat(message.getSubject()).isEqualTo("Portfolio");
        assertThat(message.getTo()[0]).isEqualTo(mailTo);
        assertThat(message.getText().contains(request.getSenderName())).isTrue();
        assertThat(message.getText().contains(request.getSenderEmail())).isTrue();

        SentMessageDb sentMessageDb = messageRepository.findAll().get(0);
        assertThat(sentMessageDb.getMessage()).isEqualTo(request.getMessage());
        assertThat(sentMessageDb.getEmail()).isEqualTo(request.getSenderEmail());
        assertThat(sentMessageDb.getName()).isEqualTo(request.getSenderName());
        assertThat(sentMessageDb.getEntryLogDb().getId()).isEqualTo(visitId);
    }
}
