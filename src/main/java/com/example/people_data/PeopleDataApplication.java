package com.example.people_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class PeopleDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeopleDataApplication.class, args);
    }

}
