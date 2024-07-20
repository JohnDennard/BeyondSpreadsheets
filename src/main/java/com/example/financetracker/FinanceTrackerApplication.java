package com.example.financetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.financetracker")
public class FinanceTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinanceTrackerApplication.class, args);
    }
}
