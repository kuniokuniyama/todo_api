package com.example.TodoAPI;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
    }
}
