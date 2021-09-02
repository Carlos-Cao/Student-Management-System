package com.example.student.management.system.main.cli;

import com.example.student.management.system.main.Student;
import com.example.student.management.system.main.StudentManagementSystemService;
import com.example.student.management.system.main.FullTimeStudent;
import com.example.student.management.system.main.PartTimeStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class CLI {

    @Autowired
    private StudentManagementSystemService studentManagementSystemService;

    public void printMenu() {
        System.out.println("");
        System.out.println("Student Management System");
        System.out.println("**************************");
        System.out.println("Enter number to select your option");
        System.out.println("0 - Exit");
        System.out.println("1 - Add New Student");
        System.out.println("2 - List Students");
        System.out.println("3 - View Student Details");
        System.out.println("4 - Delete Students");
        System.out.println("**************************");
        System.out.println("Enter your option...");
    }

    public Student addStudent(Scanner scan) {
        try {
            System.out.println("Adding a New Student");
            System.out.println("Press a number to select type of student");
            System.out.println("1 - Full Time");
            System.out.println("2 - Part Time");
            int type = scan.nextInt();
            if (type == 1) {
                return addFullTimeStudent(scan);
            } else if (type == 2) {
                return addPartTimeStudent(scan);
            }
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Wrong input detected, please try again.");
        }
        return null;
    }

    public Student addFullTimeStudent(Scanner scan) {
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
        studentManagementSystemService.addFullTimeStudent(full);
        System.out.println(full + " added!");
        return full;
    }

    public Student addPartTimeStudent(Scanner scan) {
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
        studentManagementSystemService.addPartTimeStudent(part);
        System.out.println(part + " record has been added!");
        return part;
    }

    public void listStudents() {
        System.out.println("List of Students");
        studentManagementSystemService.listStudents();
    }

    public void viewStudent(Scanner scan) {
        System.out.println("Enter Student ID to View Students Details");
        studentManagementSystemService.viewStudent(scan);

    }

    public void deleteStudent(Scanner scan) {
        System.out.println("Enter Student ID to Delete Student record");
        studentManagementSystemService.deleteStudent(scan);
    }
}
