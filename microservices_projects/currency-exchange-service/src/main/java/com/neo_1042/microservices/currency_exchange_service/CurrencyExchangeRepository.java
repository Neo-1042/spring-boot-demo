package com.neo_1042.microservices.currency_exchange_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository 
    extends JpaRepository<CurrencyExchange, Long> {
    
    // Spring Data JPA will convert this to a SQL query
    CurrencyExchange findByFromAndTo(String from, String to);
}
