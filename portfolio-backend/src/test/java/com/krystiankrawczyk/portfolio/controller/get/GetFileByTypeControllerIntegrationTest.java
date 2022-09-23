package com.krystiankrawczyk.portfolio.controller.get;

import com.krystiankrawczyk.portfolio.api.response.ErrorResponse;
import com.krystiankrawczyk.portfolio.common.RestTestHelper;
import com.krystiankrawczyk.portfolio.db.FileDb;
import com.krystiankrawczyk.portfolio.db.enums.AppFileType;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.exception.message.MessageProvider;
import com.krystiankrawczyk.portfolio.repository.FileDbRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class GetFileByTypeControllerIntegrationTest {

    @Autowired
    private RestTestHelper restTestHelper;

    @Autowired
    private FileDbRepository fileDbRepository;

    @Test
    void shouldReturnFile_ByType() {
        // Given
        FileDb fileDb = fileDbRepository.findLatestByType(AppFileType.ABOUT_ME_PHOTO).get();
        // When
        ResponseEntity<Resource> response = restTestHelper
                .getRequest(String.format("/api/v1/files/type/%s", AppFileType.ABOUT_ME_PHOTO), Resource.class)
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentDisposition().getType()).isEqualTo("attachment");
        assertThat(response.getHeaders().getContentDisposition().getFilename()).isEqualTo(fileDb.getFilename());
        assertThat(response.getBody().isReadable()).isTrue();
    }

    @Test
    void shouldThrowNotFound_WhenEntityNotFound() {
        // Given
        fileDbRepository.delete(fileDbRepository.findLatestByType(AppFileType.CV).get());
        // When
        ResponseEntity<ErrorResponse> response = restTestHelper
                .getRequest(String.format("/api/v1/files/type/%s", AppFileType.CV), ErrorResponse.class)
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getMessage()).isEqualTo(MessageProvider.getMessage(ApiMessageCode.FAILED_TO_FIND_FILE_DB));
    }

    @Test
    void shouldThrowNotFound_WhenFileNotFound() {
        // Given
        fileDbRepository.save(new FileDb()
                .setFilename("wrong_filename.jpg")
                .setFileType(AppFileType.CV)
        );
        // When
        ResponseEntity<ErrorResponse> response = restTestHelper
                .getRequest(String.format("/api/v1/files/type/%s", AppFileType.CV), ErrorResponse.class)
                .send();
        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getMessage()).isEqualTo(MessageProvider.getMessage(ApiMessageCode.FAILED_TO_FIND_FILE));
    }
}
