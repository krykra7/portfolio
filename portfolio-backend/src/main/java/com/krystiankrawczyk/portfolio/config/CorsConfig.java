package com.krystiankrawczyk.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig {

    @Value("${cors.origin}")
    private String origin;

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**")
                        .allowedMethods("PUT", "POST", "GET", "OPTIONS")
                        .allowedOrigins(origin);

                registry.addMapping("/api/v1/files/**")
                        .exposedHeaders(HttpHeaders.CONTENT_DISPOSITION);

                registry.addMapping("/api/v1/summary")
                        .exposedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS);

                registry.addMapping("/api/v1/log/**")
                        .allowedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS);

                registry.addMapping("/api/v1/message")
                        .allowedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS);
            }
        };
    }
}
