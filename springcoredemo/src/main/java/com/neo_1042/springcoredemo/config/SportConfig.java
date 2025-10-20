package com.neo_1042.springcoredemo.config;

import com.neo_1042.springcoredemo.common.Coach;
import com.neo_1042.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

	// Define the @Bean method to configure the bean
	// Manually handling the construction of this new SwimCoach
	// Give a custom ID for the bean with @Bean("someID")
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
