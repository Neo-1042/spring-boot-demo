package com.neo_1042.microservices.currency_exchange_service.controller;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neo_1042.microservices.currency_exchange_service.CurrencyExchange;
import com.neo_1042.microservices.currency_exchange_service.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

    // Choose: org.springfamework.core.env.Environment;
    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

        // This did not need an implementation :O
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if(currencyExchange == null) {
            throw new RuntimeException("Unable to find data for: from = " + from + ", to = " + to);
        }

        String port = env.getProperty("local.server.port");

        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
