package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SpringRedisDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringRedisDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisDemoApplication.class, args);
		logger.info("测试SpringRedisDemoApplication启动成功");
	}
}
