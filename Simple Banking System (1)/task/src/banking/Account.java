package banking;

import java.util.Random;

public class Account {

    private static final String ISSUER_ID = "400000";
    private static int currentCreditCardNumber = 1;

    private String ccNum;
    private String pinNum;
    private double balance;

    public Account() {
        Random random = new Random();
        createCreditCard(random);
        createPin(random);
        this.balance = 0.0;

        System.out.println("Your card has been created\n" +
                "Your card number: \n" +
                ccNum + "\n" +
                "Your card PIN:\n" +
                pinNum);
    }

    // Create new credit card
    private void createCreditCard(Random random) {
//        String customerAccountNumber = String.valueOf(random.nextInt(1_000_000_000));
        String accountId = String.format("%09d", currentCreditCardNumber);
        String checksum = String.valueOf(random.nextInt(10));
        this.ccNum = ISSUER_ID + accountId + checksum;
        currentCreditCardNumber++;
    }

    // Create 4 digit PIN
    private void createPin(Random random) {
        this.pinNum = String.format("%04d", random.nextInt(10_000));
    }

    public boolean checkCredentials(String pinInput) {
        return pinInput.equals(pinNum);
    }

    public String getCcNum() {
        return ccNum;
    }

    public String getPinNum() {
        return pinNum;
    }

    public double getBalance() {
        return balance;
    }
}
