class Student{
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String toString(){
        return getId() + " " + getFirstName() + " " + getLastName();
    }

    public static void main(String args[]){
        Student s1 = new Student(1, "Carlos", "Cao" );
        System.out.println(s1);

        FullTime s2 = new FullTime(2, "James", "Bond", "Hotel", 007);
        System.out.println(s2);

        PartTime s3 = new PartTime(3, "Part", "Timer", 3, "IW");
        System.out.println(s3);
    }
}
