package repository;

import java.util.Scanner;

public interface StudentRepository {
    public void addStudent(Scanner scan);
    public void listStudents();
    public void viewStudent(Scanner scan);
    public void deleteStudent(Scanner scan);
}
