package com.krystiankrawczyk.portfolio.controller.get;

import com.krystiankrawczyk.portfolio.common.RestTestHelper;
import com.krystiankrawczyk.portfolio.db.FileDb;
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
class GetFileByIdControllerIntegrationTest {

    @Autowired
    private RestTestHelper restTestHelper;

    @Autowired
    private FileDbRepository fileDbRepository;

    @Test
    void shouldReturnFile() {
        //    Given
        FileDb fileDb = fileDbRepository.findAll().get(0);
        //    When
        ResponseEntity<Resource> response = restTestHelper
                .getRequest(String.format("/api/v1/files/%d", fileDb.getId()), Resource.class)
                .send();
        //    Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentDisposition().getType()).isEqualTo("attachment");
        assertThat(response.getHeaders().getContentDisposition().getFilename()).isEqualTo(fileDb.getFilename());
        assertThat(response.getBody().isReadable()).isTrue();
    }
}
