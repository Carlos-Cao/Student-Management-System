package com.example.StudentManagementSystem.main.repository;

import com.example.StudentManagementSystem.main.Student;

public interface StudentRepository {
    public void addStudent(Student newStudent);

    public void listStudents();

    public void viewStudent(int viewId);

    public void deleteStudent(int removeId);
}
