package com.example.student.managment.system.repository;

import com.example.student.managment.system.main.FullTimeStudent;
import com.example.student.managment.system.main.PartTimeStudent;
import com.example.student.managment.system.main.Student;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InMemoryStudentRepository implements StudentRepository{

    private final HashMap<Integer, Student> students = new HashMap<Integer, Student>();

    @Override
    public void addStudent(Scanner scan) {
        try {
            System.out.println("Adding a New Student");
            System.out.println("Press a number to select type of student");
            System.out.println("1 - Full Time");
            System.out.println("2 - Part Time");
            int type = scan.nextInt();
            if (type == 1) {
                addFullTimeStudent(scan);
            } else if (type == 2) {
                addPartTimeStudent(scan);
            }
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Wrong input detected, please try again.");
        }
    }
    public void addFullTimeStudent(Scanner scan) {
        System.out.println("Enter student ID:");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter full time student First Name:");
        String fName = scan.nextLine();
        System.out.println("Enter full time student Last Name:");
        String lName = scan.nextLine();
        System.out.println("Enter full time student courses (4 total enter to skip):");
        String course1 = scan.nextLine();
        String course2 = scan.nextLine();
        String course3 = scan.nextLine();
        String course4 = scan.nextLine();
        String[] course = {course1, course2, course3, course4};
        System.out.println("Enter full time student Hostel name:");
        String hostel = scan.nextLine();
        System.out.println("Enter full time student year:");
        int year = scan.nextInt();
        scan.nextLine();
        FullTimeStudent full = new FullTimeStudent(id, fName, lName, course, hostel, year);
        students.put(id, full);
        System.out.println(full + " added!");
    }

    public void addPartTimeStudent(Scanner scan) {
        System.out.println("Enter student ID:");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter part time student First Name:");
        String fName = scan.nextLine();
        System.out.println("Enter part time student Last Name:");
        String lName = scan.nextLine();
        System.out.println("Enter Name of part time student courses (2 total enter to skip):");
        String course1 = scan.nextLine();
        String course2 = scan.nextLine();
        String[] course = {course1, course2};
        System.out.println("Enter part time student Level:");
        int level = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter part time student Employer:");
        String employer = scan.nextLine();
        PartTimeStudent part = new PartTimeStudent(id, fName, lName, course, level, employer);
        students.put(id, part);
        System.out.println(part + " record has been added!");
    }

    @Override
    public void listStudents() {
        System.out.println("List of Students");
        System.out.println(students);
    }

    @Override
    public void viewStudent(Scanner scan) {
        System.out.println("Enter Student ID to View Students Details");
        try {
            int viewId = scan.nextInt();
            scan.nextLine();
            System.out.println(students.get(viewId));
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Wrong input detected, please try ID again.");
        }
    }

    @Override
    public void deleteStudent(Scanner scan) {
        System.out.println("Enter Student ID to Delete Student record");
        try {
            int removeId = scan.nextInt();
            scan.nextLine();
            students.remove(removeId);
            System.out.println(removeId + " record has been removed.");
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Wrong input detected, please try ID again.");
        }
    }
}
