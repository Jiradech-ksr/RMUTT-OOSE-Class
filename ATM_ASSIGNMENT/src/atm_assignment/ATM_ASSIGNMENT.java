package ATM_ASSIGNMENT.atm_assignment;

import java.util.Scanner;

public class ATM_ASSIGNMENT {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfAccounts = 0;
            do {
                System.out.print("Enter amount of all account (1-5): ");
                try {
                    numberOfAccounts = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    numberOfAccounts = 0;
                }
            } while (numberOfAccounts < 1 || numberOfAccounts > 5);

            BankACC[] accounts = new BankACC[numberOfAccounts];
            for (int i = 0; i < numberOfAccounts; i++) {
                System.out.print("Enter Account " + (i + 1) + " ID: ");
                String accountId = scanner.nextLine();

                System.out.print("Enter Account " + (i + 1) + " Holder Name: ");
                String accountHolderName = scanner.nextLine();

                double initialBalance = -1;
                while (initialBalance < 0 || initialBalance > 1000000) {
                    System.out.print("Enter Initial Balance for account " + (i + 1) + " (0 - 1,000,000): ");
                    try {
                        initialBalance = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        initialBalance = -1;
                    }
                }

                String password;
                do {
                    System.out.print("Set a password for account " + (i + 1) + " (at least 4 chars): ");
                    password = scanner.nextLine();
                } while (password.length() < 4);

                accounts[i] = new BankACC(accountId, accountHolderName, initialBalance, password);
            }

            ATM atm = new ATM(accounts, scanner);

            while (true) {
                BankACC loggedInAccount = atm.login();
                if (loggedInAccount != null) {
                    atm.displayMenu(loggedInAccount);
                } else {
                    System.out.println("Please try again.\n");
                }
            }
        }
    }
}
