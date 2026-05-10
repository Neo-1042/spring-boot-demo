package com.neo_1042.microservices.currency_exchange_service.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neo_1042.microservices.currency_exchange_service.CurrencyExchange;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
        @PathVariable String from,
        @PathVariable String to) {

        return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
    }
}
