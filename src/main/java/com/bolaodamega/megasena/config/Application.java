package com.bolaodamega.megasena.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bolaodamega.megasena")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}