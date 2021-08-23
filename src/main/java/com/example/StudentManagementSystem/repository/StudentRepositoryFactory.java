package com.example.StudentManagementSystem.repository;

public class StudentRepositoryFactory {
    public static StudentRepository getStudentRepository() {
        return new InMemoryStudentRepository();
    }
}
