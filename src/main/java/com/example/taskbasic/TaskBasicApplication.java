package com.example.taskbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TaskBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskBasicApplication.class, args);
    }

}
