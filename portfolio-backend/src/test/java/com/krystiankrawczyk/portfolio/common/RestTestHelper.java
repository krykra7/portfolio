package com.krystiankrawczyk.portfolio.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krystiankrawczyk.portfolio.exception.SneakyThrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.net.URI;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@Component
public class RestTestHelper {

    private static final String SIZE_PARAM_NAME = "size";
    private static final String PAGE_PARAM_NAME = "page";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    public <T> TestRequestBuilder<T> postRequest(String url, Class<T> responseType) {
        return new TestRequestBuilder<>(post(URI.create(url)), responseType);
    }

    public <T> TestRequestBuilder<T> getRequest(String url, Class<T> responseType) {
        return new TestRequestBuilder<>(get(URI.create(url)), responseType);
    }

    public <T> TestRequestBuilder<T> putRequest(String url, Class<T> responseType) {
        return new TestRequestBuilder<>(put(URI.create(url)), responseType);
    }

    public TestRequestBuilder<Void> putRequest(String url) {
        return new TestRequestBuilder<>(put(URI.create(url)), Void.class);
    }

    public TestRequestBuilder<Void> deleteRequest(String url) {
        return new TestRequestBuilder<>(delete(URI.create(url)), Void.class);
    }

    private <T> ResponseEntity<T> makeRequest(MockHttpServletRequestBuilder request, Class<T> responseType) {
        try {
            MockHttpServletResponse result = mockMvc.perform(request)
                    .andReturn()
                    .getResponse();

            return convertToResponseEntity(result, responseType);
        } catch (Exception e) {
            throw SneakyThrow.throwSneaky(e);
        }
    }

    private <T> ResponseEntity<T> convertToResponseEntity(
            MockHttpServletResponse response,
            Class<T> responseType) throws IOException {

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        T body = null;

        if (responseType != Void.class) {
            if (responseType == Resource.class) {
                body = (T) new ByteArrayResource(response.getContentAsByteArray());
            } else {
                body = objectMapper.readValue(response.getContentAsString(), responseType);
            }
        }

        HttpStatus status = HttpStatus.resolve(response.getStatus());
        return new ResponseEntity<>(body, getHeaders(response), status != null ? status : HttpStatus.BAD_REQUEST);
    }

    private MultiValueMap<String, String> getHeaders(MockHttpServletResponse response) {
        return new LinkedMultiValueMap<>(response
                .getHeaderNames()
                .stream()
                .collect(Collectors.toMap(Function.identity(), response::getHeaders)));
    }

    public class TestRequestBuilder<R> {
        private static final String contentType = "application/json";
        private static final String fileContentType = "application/octet-stream";
        private final Class<R> responseType;
        private final MockHttpServletRequestBuilder requestBuilder;

        TestRequestBuilder(MockHttpServletRequestBuilder requestBuilder, Class<R> responseType) {
            this.requestBuilder = requestBuilder;
            this.responseType = responseType;
        }

        public ResponseEntity<R> send() {
            if (responseType == Resource.class) {
                requestBuilder.contentType(fileContentType);
            } else {
                requestBuilder.contentType(contentType);
            }

            return makeRequest(requestBuilder, responseType);
        }

        public TestRequestBuilder<R> body(Object body) {
            try {
                requestBuilder.content(objectMapper.writeValueAsString(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return this;
        }

        public TestRequestBuilder<R> param(String name, Object value) {
            requestBuilder.param(name, String.valueOf(value));
            return this;
        }

        public TestRequestBuilder<R> pagination(int number, int size) {
            this.param(PAGE_PARAM_NAME, number);
            this.param(SIZE_PARAM_NAME, size);
            return this;
        }

        public TestRequestBuilder<R> header(String name, Object... values) {
            requestBuilder.header(name, values);
            return this;
        }

        public TestRequestBuilder<R> cookie(String name, String value) {
            requestBuilder.cookie(new Cookie(name, value));
            return this;
        }
    }
}
