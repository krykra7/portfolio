package com.krystiankrawczyk.portfolio.controller.put;

import com.krystiankrawczyk.portfolio.api.response.ErrorResponse;
import com.krystiankrawczyk.portfolio.common.RestTestHelper;
import com.krystiankrawczyk.portfolio.db.EntryLogDb;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.exception.message.MessageProvider;
import com.krystiankrawczyk.portfolio.repository.EntryLogRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
class PutEntryLogControllerIntegrationTest {

    @Autowired
    private RestTestHelper restTestHelper;

    @Autowired
    private EntryLogRepository entryLogRepository;

    @BeforeEach
    public void clean() {
        entryLogRepository.deleteAll();
    }

    @Test
    void shouldUpdateEntry() {
        // Given
        EntryLogDb entryLogDb = entryLogRepository.save(new EntryLogDb()
                .setEnterDate(LocalDateTime.MIN)
                .setLeaveDate(LocalDateTime.MIN));
        // When
        ResponseEntity<Void> response = restTestHelper.putRequest("/api/v1/log/entry")
                .cookie("visit-id", String.valueOf(entryLogDb.getId()))
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        EntryLogDb updatedEntry = entryLogRepository.findAll().get(0);
        assertThat(updatedEntry.getLeaveDate()).isNotEqualTo(LocalDateTime.MIN);
        assertThat(updatedEntry.getId()).isEqualTo(entryLogDb.getId());
    }

    @Test
    void shouldReturnErrorResponse_WhenEntryDoesNotExist() {
        // Given
        // When
        ResponseEntity<ErrorResponse> response = restTestHelper.putRequest("/api/v1/log/entry", ErrorResponse.class)
                .cookie("visit-id", "10")
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getMessage()).isEqualTo(MessageProvider.getMessage(ApiMessageCode.ENTRY_NOT_FOUND));
    }
}
