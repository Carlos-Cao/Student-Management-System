package com.example.StudentManagementSystem.main;

import com.example.StudentManagementSystem.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystemApplication implements RunInterface{

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CLI cli;

    @Override
    public void run() {

        //StudentRepository studentRepo = StudentRepositoryFactory.getStudentRepository();

        Scanner scan = getScanner();

        boolean exit = false;
        do {
            cli.printMenu();
            try {
                int option = scan.nextInt();
                switch (option) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        cli.addStudent(scan);
                        break;
                    case 2:
                        cli.listStudents();
                        break;
                    case 3:
                        cli.viewStudent(scan);
                        break;
                    case 4:
                        cli.deleteStudent(scan);
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

    public void listStudents() {
        System.out.println("List of Students");
        studentRepo.listStudents();
    }

    public void viewStudent(Scanner scan) {
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
