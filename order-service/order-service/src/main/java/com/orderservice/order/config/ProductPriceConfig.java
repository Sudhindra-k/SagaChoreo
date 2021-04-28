package com.orderservice.order.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductPriceConfig {

	
	@Bean
	public Map<Integer, Integer> prodcutPrice(){
		
		return Map.of(
				1, 100,
				2, 200,
				3,300
				);
		
	};
	
}
