import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("PASSWORD: " + this.password);

        // Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New Worker: " + firstName + ".\n" +
                "Choose your Department Code\n 1 for Sales\n 2 for Development\n " +
                "3 for Accounting\n 0 for None\n Enter Department Code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {return "sales";}
        else if (departmentChoice == 2) {return "dev";}
        else if (departmentChoice == 3) {return "acc";}
        return "";
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%abcdefghijklmnopqrstuvwxyz";
        char[] password = new char[length];
        for (int i=0;i<length;i++) {
            int index = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(index);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "MB";

    }
}
