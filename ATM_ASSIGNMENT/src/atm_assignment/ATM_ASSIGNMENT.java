package atm_assignment;

import java.util.Scanner;

public class ATM_ASSIGNMENT {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int numberOfAccounts = 0;
            do {
                System.out.print("Enter amount of all account : ");
                numberOfAccounts = Integer.parseInt(scanner.nextLine());
            } while (numberOfAccounts < 1 || numberOfAccounts > 5);

            BankACC[] accounts = new BankACC[numberOfAccounts];
            for (int i = 0; i < numberOfAccounts; i++) {

                System.out.print("Enter Account " + (i + 1) + " ID: ");
                String accountId = scanner.nextLine();

                System.out.print("Enter Account " + (i + 1) + " Holder Name: ");
                String accountHolderName = scanner.nextLine();

                System.out.print("Enter Initial Balance for account " + (i + 1) + ": ");
                double initialBalance = Double.parseDouble(scanner.nextLine());
                while (initialBalance < 0 || initialBalance > 1000000) {
                    System.out.print("Invalid balance. Enter amount between 0 and 1,000,000: ");
                    initialBalance = Double.parseDouble(scanner.nextLine());
                }
                System.out.print("Set a password for account " + (i + 1) + ": ");
                String password = scanner.nextLine();
                while (password.length() < 4) {
                    System.out.print("Password must be at least 4 characters. Try again: ");
                    password = scanner.nextLine();
                }
                accounts[i] = new BankACC(accountId, accountHolderName, initialBalance, password);

            }
            ATM atm = new ATM(accounts);
            while (true) {
                BankACC loggedInAccount = atm.login();
                if (loggedInAccount != null) {
                    atm.displayBalance(loggedInAccount);
                } else {
                    System.out.println("Please try again.\n");
                }
            }
        }
    }
}
