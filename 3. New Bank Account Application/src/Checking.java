public class Checking extends Account {
    // List properties to a checking account
    private int debitCardNumber;
    private int getDebitCardPin;

    // Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = 2 + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * (0.15);
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        getDebitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }


    // List any methods specific to Checking Account
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Your Checking Account Features" +
                        "\n     Debit Card Number: " + debitCardNumber +
                        "\n     Debit Card Pin: " + getDebitCardPin
        );
    }
}
