package com.example.student.management.system.main;

import com.example.student.management.system.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RequestMapping("api/students")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        if (student != null) {
            studentRepository.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header(HttpHeaders.LOCATION, "http://localhost:8080/api/students/" + student.getId())
                    .body(studentRepository.viewStudent(student.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.listStudents();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        if (studentRepository.viewStudent(id) != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(studentRepository.viewStudent(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudentById(@PathVariable("id") int id) {
        studentRepository.deleteStudent(id);
    }
}
