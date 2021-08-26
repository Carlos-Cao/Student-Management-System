package com.example.StudentManagementSystem.main.repository;

import com.example.StudentManagementSystem.main.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Profile("inMemoryStudentRepository")
public class InMemoryStudentRepository implements StudentRepository {

    private final HashMap<Integer, Student> students = new HashMap<Integer, Student>();


    @Override
    public void addStudent(Student newStudent) {
        students.put(newStudent.getId(), newStudent);

    }

    @Override
    public void listStudents() {
        System.out.println(students);
    }

    @Override
    public void viewStudent(int viewId) {
        System.out.println(students.get(viewId));

    }

    @Override
    public void deleteStudent(int removeId) {
        students.remove(removeId);
        System.out.println(removeId + " record has been removed.");

    }
}
