package com.baoxue.carrental;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"com.baoxue.carrental.mapper"})
@SpringBootApplication
@EnableTransactionManagement
public class CarrentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrentalApplication.class, args);
    }

}
