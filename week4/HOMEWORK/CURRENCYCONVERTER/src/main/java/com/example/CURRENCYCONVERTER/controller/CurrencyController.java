package com.example.CURRENCYCONVERTER.controller;

import com.example.CURRENCYCONVERTER.dto.CurrencyResponseDto;
import com.example.CURRENCYCONVERTER.service.CurrencyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CurrencyController {
    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;


    }
    @GetMapping("/convertCurrency")
    public CurrencyResponseDto convertcurrency(  @RequestParam String fromCurrency ,
                                                 @RequestParam  String toCurrency ,
                                                 @RequestParam  Double units ){
        return currencyService.ConvertCurrency(fromCurrency,toCurrency,units);

    }

}
