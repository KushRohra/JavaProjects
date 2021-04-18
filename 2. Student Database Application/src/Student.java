import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor : prompt user to enter Student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();
        System.out.print("1 - Freshman \n2 - Sophomore \n3 - Junior \n4 - Senior \nEnter student class level: ");
        this.gradeYear = in.nextLine();

        setStudentID();
    }

    // Generate an ID
    private void setStudentID() {
        id++;
        studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        System.out.println("");
        do {
            System.out.print("Enter Course to enroll (Q/q to quit) ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q") && !course.equals("q")) {
                if (courses.equals(""))
                    courses = course;
                else
                    courses += ", " + course;
                tuitionBalance += costOfCourse;
            }
            else break;
        } while(true);
    }

    // View balance
    public void viewBalance() {
        if (tuitionBalance == 0)
            System.out.println("You don't have to make any payments");
        System.out.println("Your current balance is: Rs. " + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        System.out.println("");
        viewBalance();
        if (tuitionBalance == 0)
            return;
        System.out.print("Enter your payment: Rs. ");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of Rs. " + payment);
        viewBalance();
    }

    // Show status
    public String showInfo() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Grade Level: " + gradeYear + "\n" +
                "Student ID: " + studentID + "\n" +
                "Courses Enrolled: " + courses + "\n" +
                "Balance: Rs. " + tuitionBalance;
    }
}
