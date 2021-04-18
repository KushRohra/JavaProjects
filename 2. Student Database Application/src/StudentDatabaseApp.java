import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        // Ask how many new students we want to add
        System.out.print("Enter number of new Students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];
        System.out.println("");

        // Create n number of Students
        for (int i=0;i<numOfStudents;i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.println("");
        }

        for (int i=0;i<numOfStudents;i++) {
            System.out.println("Details for Student No. " + (i + 1));
            System.out.println(students[i].showInfo());
            System.out.println();
        }
    }
}
