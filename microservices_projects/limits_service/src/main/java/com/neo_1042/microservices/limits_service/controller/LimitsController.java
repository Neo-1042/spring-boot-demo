package com.neo_1042.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo_1042.microservices.limits_service.bean.Limits;
import com.neo_1042.microservices.limits_service.configuration.Configuration;

@RestController
public class LimitsController {

    // Make use of the Configuration class' properties:
    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(config.getMinimum(), config.getMaximum());
    }
}
