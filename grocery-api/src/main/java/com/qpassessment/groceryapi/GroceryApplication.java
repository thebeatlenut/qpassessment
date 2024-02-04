package com.qpassessment.groceryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.qpassessment.groceryapi.*")
public class GroceryApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroceryApplication.class, args);
    }
}
