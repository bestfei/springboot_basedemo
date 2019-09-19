package com.bestfei.springboot_basedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootBasedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBasedemoApplication.class, args);
	}

}
