package com.example.employee_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class EmployeeTaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmployeeTaskApplication.class, args);
    }

}
