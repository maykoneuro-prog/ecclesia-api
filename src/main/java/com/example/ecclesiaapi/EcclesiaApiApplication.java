package com.example.ecclesiaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.ecclesiaapi")
public class EcclesiaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcclesiaApiApplication.class, args);
    }
}