package com.example.student.management.system.main.template;

import com.example.student.management.system.main.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

    @Autowired
    private StudentRestClient studentRestClient;

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student newStudent = new Student(7, "James", "Smith", new String[]{"Maths, Science, English"}, Student.StudentType.FULLTIME);
        studentRestClient.addNewStudent(newStudent);
        Student james = studentRestClient.getStudent(7);
        System.out.println(james + " has been created.");

        List<Student> getAllStudents= studentRestClient.getAllStudents();
        System.out.println("All Students listed: " + getAllStudents);

        Student selectStudent = studentRestClient.getStudent(7);
        System.out.println("View Student: " + selectStudent);
    }
}
