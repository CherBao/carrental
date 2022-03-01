package com.baoxue.carrental;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.baoxue.carrental.mapper"})
@SpringBootApplication
public class CarrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrentalApplication.class, args);
	}

}
