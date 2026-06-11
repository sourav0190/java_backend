package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    @Qualifier("employeeRestClient")
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
