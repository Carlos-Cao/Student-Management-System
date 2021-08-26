package com.example.StudentManagementSystem.main.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dbStudentRepository")
public class DBStudentRepository {

}
