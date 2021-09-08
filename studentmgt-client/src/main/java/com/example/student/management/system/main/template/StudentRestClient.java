package com.example.student.management.system.main.template;

import com.example.student.management.system.main.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentRestClient {

    @Value("${service.url}")
    private String baseUri;

    @Autowired
    private RestTemplate restTemplate;

    public void addNewStudent(Student newStudent) {
        restTemplate.postForObject(baseUri, newStudent, Student.class);
    }

    public List<Student> getAllStudents() {
        Student[] studentArray = restTemplate.getForObject(baseUri, Student[].class);
        return Arrays.asList(studentArray);
    }

    public Student getStudent(int id) {
        return restTemplate.getForObject(baseUri + id, Student.class);
    }
}
