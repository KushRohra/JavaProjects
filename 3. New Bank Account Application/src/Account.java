public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;

    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        // Set Account Number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random()*(Math.pow(10, 3)));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        System.out.println("Accrued Interest: Rs" + accruedInterest);
        balance += accruedInterest;
        printBalance();
    }

    //  List common methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing Rs " + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        if (balance - amount < 0) {
            System.out.println("You cannot withdraw Rs " + amount + " from your account\n");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawing Rs " + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        if (balance - amount < 0) {
            System.out.println("You cannot transfer Rs " + amount + " from your account\n");
            return;
        }
        balance -= amount;
        System.out.println("Transferring Rs " + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your Balance is now: Rs " + balance + "\n");
    }

    public void showInfo() {
        System.out.println(
                        "Name: " + this.name + "\n" +
                        "Account Number: " + this.accountNumber + "\n" +
                        "Balance: Rs " + this.balance + "\n" +
                        "Rate: " + rate + "%"
        );
    }
}
