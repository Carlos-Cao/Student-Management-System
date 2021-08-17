package com.example.student.management.system.repository;

public class StudentRepositoryFactory {
    public static StudentRepository getStudentRepository() {
        return new InMemoryStudentRepository();
    }
}
