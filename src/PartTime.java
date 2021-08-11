class PartTime extends Student {
    int level;
    String employer;

    public PartTime(int id, String firstName, String lastName, int level, String employer) {
        super(id, firstName, lastName);
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
