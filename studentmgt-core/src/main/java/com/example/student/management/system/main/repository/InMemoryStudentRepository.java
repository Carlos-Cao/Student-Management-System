package com.example.student.management.system.main.repository;

import com.example.student.management.system.main.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Profile("inMemoryStudentRepository")
public class InMemoryStudentRepository implements StudentRepository {

    private final HashMap<Integer, Student> students = new HashMap<Integer, Student>();

    @Override
    public Student addStudent(Student newStudent) {
        students.put(newStudent.getId(), newStudent);
        return newStudent;
    }

    @Override
    public HashMap<Integer, Student> listStudents() {
        System.out.println(students);
        return students;
    }

    @Override
    public Student viewStudent(int viewId) {
        System.out.println(students.get(viewId));
        return students.get(viewId);
    }

    @Override
    public void deleteStudent(int removeId) {
        students.remove(removeId);
        System.out.println(removeId + " record has been removed.");
    }
}
