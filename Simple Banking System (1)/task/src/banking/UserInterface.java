package banking;

import java.util.Scanner;

public class UserInterface {

    Bank bank;

    public UserInterface() {
        bank = new Bank();
    }

    // Top level menu
    public boolean mainMenu(Scanner scanner) {
        boolean exit = false;

        System.out.println("1. Create an account\n" +
                "2. Log into account\n" +
                "0. Exit");

        String input = scanner.nextLine();
        System.out.println();

        if ("1".equals(input)) {
            bank.createAccount();
            return false;
        } else if ("2".equals(input)) {
            logIn(scanner);
            return false;
        } else if ("0".equals(input)) {
            System.out.println("Bye!");
            exit = true;
        }
        return exit;
    }

    // Menu to log into account
    public void logIn(Scanner scanner) {
        boolean cardNumExists = false;
        boolean pinCorrect = false;
        System.out.println("Enter your card number:");
        String cardNum = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String pinNum = scanner.nextLine();

        // Check to see if Cc number exists, then check if PIN matches.
        for (Account account : bank.getAccounts()) {
            String currCc = account.getCcNum();
            if (currCc.equals(cardNum)) {
                cardNumExists = true;
                String currPin = account.getPinNum();
                if (currPin.equals(pinNum)) {
                    pinCorrect = true;
                    System.out.println("\nYou have successfully logged in!\n");
                    loggedInMenu(scanner, account);
                }
            }
        }
        if (!(cardNumExists && pinCorrect)) {
            System.out.println("\nWrong card number or PIN!\n");
        }
    }

    // Menu once successfully logged in
    public void loggedInMenu(Scanner scanner, Account account) {
        System.out.println("1. Balance\n" +
                "2. Log out\n" +
                "0. Exit");
        String input = scanner.nextLine();
        if ("1".equals(input)) {
            System.out.println("\nBalance: " + account.getBalance() + "\n");
        } else if ("2".equals(input)) {
            return;
        }

    }


}
