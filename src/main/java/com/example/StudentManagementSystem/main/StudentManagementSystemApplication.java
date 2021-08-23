package com.example.StudentManagementSystem.main;

import com.example.StudentManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.StudentManagementSystem.repository"})
public class StudentManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepo;

	public static void main(String[] args) {

		SpringApplication.run(StudentManagementSystemApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		//StudentRepository studentRepo = StudentRepositoryFactory.getStudentRepository();

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
						studentRepo.addStudent(scan);
						break;
					case 2:
						studentRepo.listStudents();
						break;
					case 3:
						studentRepo.viewStudent(scan);
						break;
					case 4:
						studentRepo.deleteStudent(scan);
						break;
				}
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("Wrong input detected, please select an option from the following.");
			}
		} while (!exit);
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

}
