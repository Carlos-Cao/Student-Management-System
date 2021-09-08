package com.example.student.management.system.main;

public class Student {

    public enum StudentType {
        FULLTIME,
        PARTTIME
    };

    private int id;
    private String firstName;
    private String lastName;
    private String[] courses;
    private StudentType studentType;

    public Student() {

    }

    public Student(int id, String firstName, String lastName, String[] courses, StudentType studentType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
        this.studentType = studentType;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public String toString() {
        String coursesList = "";
        for (String s : getCourses()){
            coursesList = coursesList + " " + s;
        }
        return "Id: " + getId() +
                ", First Name: " + getFirstName() +
                ", Last Name: " + getLastName() +
                ", Courses: " + coursesList +
                ", Student Type: " + getStudentType();
    }

}
