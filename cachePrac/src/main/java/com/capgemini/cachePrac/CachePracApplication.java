package com.capgemini.cachePrac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CachePracApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachePracApplication.class, args);
	}

//	@Bean
//	public CacheManager getCacheManager() {
//		return new ConcurrentMapCacheManager();
//	}
}
