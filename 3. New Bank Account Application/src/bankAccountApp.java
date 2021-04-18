import java.util.LinkedList;
import java.util.List;

public class bankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // Read a csv file then create a new account based on that data
        String file = "NewBankAccounts.csv";
        List<String[]> newAccountOrders = utilities.CSV.read(file);

        for (String[] accountHolder : newAccountOrders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initBalance = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initBalance));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initBalance));
            } else {
                System.out.println("Error Reading Account Type");
            }
        }
        for (Account acc : accounts) {
            System.out.println("\n*******************");
            acc.showInfo();
        }
        System.out.println("\n*******************");
    }
}
