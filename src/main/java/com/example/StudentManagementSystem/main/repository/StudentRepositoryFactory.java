package com.example.StudentManagementSystem.main.repository;

public class StudentRepositoryFactory {

    public static StudentRepository getStudentRepository() {
        return new InMemoryStudentRepository();
    }

}
