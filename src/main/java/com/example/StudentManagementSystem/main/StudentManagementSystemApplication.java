package com.example.StudentManagementSystem.main;

import com.example.StudentManagementSystem.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepo;


    public static void main(String[] args) {

        SpringApplication.run(StudentManagementSystemApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        //StudentRepository studentRepo = StudentRepositoryFactory.getStudentRepository();

        Scanner scan = getScanner();

        boolean exit = false;
        do {
            printMenu();
            try {
                int option = scan.nextInt();
                switch (option) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        addStudent(scan);
                        break;
                    case 2:
                        listStudents();
                        break;
                    case 3:
                        viewStudent(scan);
                        break;
                    case 4:
                        deleteStudent(scan);
                        break;
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Wrong input detected, please select an option from the following.");
            }
        } while (!exit);
    }

    public static Scanner getScanner() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public static void printMenu() {
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
        studentRepo.addStudent(full);
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
        studentRepo.addStudent(part);
        System.out.println(part + " record has been added!");
    }

    public void listStudents() {
        System.out.println("List of Students");
        studentRepo.listStudents();
    }

    public void viewStudent(Scanner scan) {
        System.out.println("Enter Student ID to View Students Details");
        try {
            int viewId = scan.nextInt();
            scan.nextLine();
            studentRepo.viewStudent(viewId);
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Wrong input detected, please try ID again.");
        }
    }

    public void deleteStudent(Scanner scan) {
        System.out.println("Enter Student ID to Delete Student record");
        try {
            int removeId = scan.nextInt();
            scan.nextLine();
            studentRepo.deleteStudent(removeId);
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Wrong input detected, please try ID again.");
        }
    }

}
