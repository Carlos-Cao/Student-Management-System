package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final HashMap<Integer, String> students = new HashMap<Integer, String>();

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

    public static void listStudents() {
        System.out.println("List of Students");
        System.out.println(students);
    }

    public static void viewStudent(Scanner scan) {
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

    public static void deleteStudent(Scanner scan) {
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

    public static void addStudent(Scanner scan) {
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

    public static void addFullTimeStudent(Scanner scan) {
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
        students.put(id, " First Name: " + fName + ", Last Name: " + lName + ", Courses: " + Arrays.toString(course) + ", Hostel Name: " + hostel + ", Year: " + year + "\n");
        System.out.println(full + " added!");
    }

    public static void addPartTimeStudent(Scanner scan) {
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
        students.put(id, " First Name: " + fName + ", Last Name: " + lName + ", Courses: " + Arrays.toString(course) + ", Level: " + level + ", Employer: " + employer + "\n");
        System.out.println(part + " record has been added!");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

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
}
