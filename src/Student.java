import java.util.HashMap;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        HashMap<Integer, String> students = new HashMap<Integer, String>();
        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Add New Student");
            System.out.println("2 - List Students");
            System.out.println("3 - View Student Details");
            System.out.println("4 - Delete Students");
            System.out.println("Enter your option...");
            int option = scan.nextInt();
            switch (option){
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Add New Student");
                    System.out.println("Set ID:");
                    int id = scan.nextInt();
                    System.out.println("Set First Name:");
                    String fName = scan.nextLine();
                    System.out.println("Set Last Name:");
                    String lName = scan.nextLine();
                    Student newStudent = new Student(id, fName, lName);
                    students.put(id, lName);
                    System.out.println(newStudent);
                    break;

                case 2:
                    System.out.println("List of Students");
                    System.out.println(students);
                    break;

                case 3:
                    System.out.println("Enter ID to View Students Details");
                    break;

                case 4:
                    System.out.println("Enter ID to Delete Student");
                    break;
            }

        } while (!exit);
    }

}
