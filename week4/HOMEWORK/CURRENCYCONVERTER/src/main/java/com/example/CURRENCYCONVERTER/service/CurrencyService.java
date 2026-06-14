package com.example.CURRENCYCONVERTER.service;

import com.example.CURRENCYCONVERTER.dto.CurrencyResponseDto;
import com.example.CURRENCYCONVERTER.dto.FrankfurterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
@Slf4j
public class CurrencyService {
    @Value("${freecurrency.api.key}")
    public String apikey;
    @Value("${freecurrency.api.url}")
    public String apiurl;
    private final RestClient restClient;

    public CurrencyService(RestClient restClient) {
        this.restClient = restClient;
    }

    public CurrencyResponseDto ConvertCurrency(
            String fromCurrency,
            String toCurrency,
            Double units) {
        String from = fromCurrency.toUpperCase();
        String to = toCurrency.toUpperCase();
        log.info("Currency conversion started");

        log.info("From Currency: {}, To Currency: {}, Units: {}",
                from, to, units);

        log.info("Calling FreeCurrency API");

        FrankfurterResponseDto responsedto = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(apiurl)
                        .queryParam("apikey", apikey)

                        .queryParam("base_currency", from)
                        .queryParam("currencies", to)
                        .build())
                .retrieve()
                .body(FrankfurterResponseDto.class);
        log.info("Free Currency API response: {}", responsedto);

        Double exchangedRate = responsedto.getData().get(to);
        log.info("Free Currency API rate: {}", exchangedRate);
        Double convertedAmount = units * exchangedRate;
        log.info("Free Currency API converted amount: {}", convertedAmount);
        return new CurrencyResponseDto(
                from,
                to,
                units,
                exchangedRate,
                convertedAmount);

    }

}
