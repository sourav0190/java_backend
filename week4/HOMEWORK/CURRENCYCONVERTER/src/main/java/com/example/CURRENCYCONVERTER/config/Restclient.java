package com.example.CURRENCYCONVERTER.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;
@Configuration
public class Restclient {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://api.freecurrencyapi.com")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
    }
