package com.example.student.management.system.main.repository;

import com.example.student.management.system.main.Student;

import java.util.List;

public interface StudentRepository {
    public Student addStudent(Student newStudent);

    public List<Student> listStudents();

    public Student viewStudent(int viewId);

    public void deleteStudent(int removeId);
}
