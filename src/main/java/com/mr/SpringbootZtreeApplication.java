package com.mr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mr.mapper")
public class SpringbootZtreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootZtreeApplication.class, args);
	}
}

