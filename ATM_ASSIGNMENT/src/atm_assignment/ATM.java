package ATM_ASSIGNMENT.atm_assignment;
import java.util.Scanner;

public class ATM {
    private BankACC[] accounts;
    private Scanner scanner;

    public ATM(BankACC[] accounts, Scanner scanner) {
        this.accounts = accounts;
        this.scanner = scanner;
    }

    public BankACC login() {
        System.out.println("\n\n\t\t\tATM ComputerThanyaburi Bank\n");
        System.out.print("Enter Account ID: ");
        String inputId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String inputPassword = scanner.nextLine();

        for (BankACC account : accounts) {
            if (account.getAccountId().equals(inputId) && account.checkPassword(inputPassword)) {
                System.out.println("Login successful!\n");
                return account;
            }
        }
        System.out.println("Invalid Account ID or Password.");
        return null;
    }

    public void displayMenu(BankACC account) {
        while (true) {
            System.out.println("=========================================");
            System.out.println("Account ID : " + account.getAccountId());
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Menu Service\n");
            System.out.println("1. Account Balance");
            System.out.println("2. Withdrawal");
            System.out.println("3. Logout\n");
            System.out.print("Choose : ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Your balance is: " + account.getBalance());
                    break;
                case "2":
                    System.out.print("Enter amount to withdraw: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;
                case "3":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}
