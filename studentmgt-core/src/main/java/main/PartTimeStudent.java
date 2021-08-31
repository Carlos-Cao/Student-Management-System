package main;

public class PartTimeStudent extends Student {

    private int level;
    private String employer;

    public PartTimeStudent(int id, String firstName, String lastName, String[] courses, int level, String employer) {
        super(id, firstName, lastName, courses);
        this.level = level;
        this.employer = employer;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmployer() {
        return employer;
    }

    @Override
    public String toString() {
        return getId() + " " + getFirstName() + " " + getLastName() + " " + getLevel() + " " + getEmployer();
    }
}
