package com.biking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableCaching
@EnableRedisRepositories(basePackages = "com.dummy.package.that.does.not.exist")
public class BikingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikingApplication.class, args);
	}

}
