package com.example.StudentManagementSystem.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRun implements CommandLineRunner {

    @Autowired
    StudentManagementSystemApplication StudentRun;

    public static void main(String[] args) {

        SpringApplication.run(StudentManagementSystemApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        StudentRun.run();
    }
}
