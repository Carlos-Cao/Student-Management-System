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
            System.out.println("");
            System.out.println("Student Management System");
            System.out.println("**************************");
            System.out.println("Enter number to select your option");
            System.out.println("0 - Exit");
            System.out.println("1 - Add New Student");
            System.out.println("2 - List Students");
            System.out.println("3 - View Student Details");
            System.out.println("4 - Delete Students");
            System.out.println("**************************");
            System.out.println("Enter your option...");
            try {
                int option = scan.nextInt();
                switch (option) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        try {
                            System.out.println("Adding a New Student");
                            System.out.println("Press a number to select type of student");
                            System.out.println("1 - Full Time");
                            System.out.println("2 - Part Time");
                            int type = scan.nextInt();
                            if (type == 1) {
                                System.out.println("Enter student ID:");
                                int id = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Enter full time student First Name:");
                                String fName = scan.nextLine();
                                System.out.println("Enter full time student Last Name:");
                                String lName = scan.nextLine();
                                System.out.println("Enter full time student Hostel name:");
                                String hostel = scan.nextLine();
                                System.out.println("Enter full time student year:");
                                int year = scan.nextInt();
                                scan.nextLine();
                                FullTime full = new FullTime(id, fName, lName, hostel, year);
                                students.put(id, " First Name: " + fName + ", Last Name: " + lName + ", Hostel Name: " + hostel + ", Year: " + year);
                                System.out.println(full + " added!");
                            } else if (type == 2) {
                                System.out.println("Enter student ID:");
                                int id = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Enter part time student First Name:");
                                String fName = scan.nextLine();
                                System.out.println("Enter part time student Last Name:");
                                String lName = scan.nextLine();
                                System.out.println("Enter part time student Level:");
                                int level = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Enter part time student Employer:");
                                String employer = scan.nextLine();
                                PartTime part = new PartTime(id, fName, lName, level, employer);
                                students.put(id, " First Name: " + fName + ", Last Name: " + lName + ", Level: " + level + ", Employer: " + employer);
                                System.out.println(part + " record has been added!");
                            }
                        } catch (java.util.InputMismatchException e) {
                            scan.nextLine();
                            System.out.println("Wrong input detected, please try again.");
                        }
                        break;

                    case 2:
                        System.out.println("List of Students");
                        System.out.println(students);
                        break;

                    case 3:
                        System.out.println("Enter Student ID to View Students Details");
                        try {
                            int viewId = scan.nextInt();
                            scan.nextLine();
                            System.out.println(students.get(viewId));
                        }
                        catch (java.util.InputMismatchException e) {
                        scan.nextLine();
                        System.out.println("Wrong input detected, please try ID again.");
                    }
                        break;

                    case 4:
                        System.out.println("Enter Student ID to Delete Student record");
                        try {
                            int removeId = scan.nextInt();
                            scan.nextLine();
                            students.remove(removeId);
                            System.out.println(removeId + " record has been removed.");
                        }
                        catch (java.util.InputMismatchException e) {
                            scan.nextLine();
                            System.out.println("Wrong input detected, please try ID again.");
                        }
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                scan.nextLine();
                System.out.println("Wrong input detected, please select an option from the following.");
            }

        } while (!exit);
    }

}
