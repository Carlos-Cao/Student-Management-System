class FullTime extends Student{
    String hostelName;
    int year;

    public FullTime(int id, String firstName, String lastName, String hostelName, int year) {
        super(id, firstName, lastName);
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
        return getId() + " " + getFirstName() + " " + getLastName() + " " + getHostelName() + " " + getYear();
    }
}
