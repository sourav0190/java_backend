package com.example.CURRENCYCONVERTER.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResponseDto {
    private String fromCurrency;
    private String toCurrency;
    private Double units;
    private Double exchangeRate;
    private Double ConvertedAmount;
}
