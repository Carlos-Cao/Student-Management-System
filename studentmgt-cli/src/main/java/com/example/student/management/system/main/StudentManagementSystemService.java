package com.example.student.management.system.main;

import com.example.student.management.system.main.cli.CLI;
import com.example.student.management.system.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentManagementSystemService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CLI cli;

    public void run() {

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

    public Student addFullTimeStudent(Student full) {
        return studentRepo.addStudent(full);
    }

    public Student addPartTimeStudent(Student part) {
        return studentRepo.addStudent(part);
    }

    public List<Student> listStudents() {
        return studentRepo.listStudents();
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
