package main;

class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String[] courses;

    public Student(int id, String firstName, String lastName, String[] courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;

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

    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + getCourses();
    }

}
