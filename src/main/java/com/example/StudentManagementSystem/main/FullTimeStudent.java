package com.example.StudentManagementSystem.main;

public class FullTimeStudent extends Student {

    private String hostelName;
    private int year;

    public FullTimeStudent(int id, String firstName, String lastName, String[] courses, String hostelName, int year) {
        super(id, firstName, lastName, courses);
        this.hostelName = hostelName;
        this.year = year;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName() + ", Hostel Name: " + getHostelName() + ", Year: " + getYear();
    }
}

