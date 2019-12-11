package com.bestfei.springboot_basedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.bestfei.springboot_basedemo.mapper")
public class SpringbootBasedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBasedemoApplication.class, args);
	}

}
