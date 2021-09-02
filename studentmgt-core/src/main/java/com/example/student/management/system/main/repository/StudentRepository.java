package com.example.student.management.system.main.repository;

import com.example.student.management.system.main.Student;

import java.util.HashMap;

public interface StudentRepository {
    public Student addStudent(Student newStudent);

    public HashMap<Integer, Student> listStudents();

    public Student viewStudent(int viewId);

    public void deleteStudent(int removeId);
}
