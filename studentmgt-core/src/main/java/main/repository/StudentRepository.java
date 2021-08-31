package main.repository;

import main.Student;

public interface StudentRepository {
    public void addStudent(Student newStudent);

    public void listStudents();

    public void viewStudent(int viewId);

    public void deleteStudent(int removeId);
}
