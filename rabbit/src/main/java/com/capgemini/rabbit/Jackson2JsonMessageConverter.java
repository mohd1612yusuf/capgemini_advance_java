package com.capgemini.rabbit;

import org.springframework.context.annotation.Bean;

public class Jackson2JsonMessageConverter {
	@Bean
	public Jackson2JsonMessageConverter jsonMessage() {
		return new Jackson2JsonMessageConverter();
	}
}
