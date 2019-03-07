package com.fish.salted;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fish.salted.dao")
public class SaltedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaltedApplication.class, args);
        System.out.println("spring init!");
    }

}
