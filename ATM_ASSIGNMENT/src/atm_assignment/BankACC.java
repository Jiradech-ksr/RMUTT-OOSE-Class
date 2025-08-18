package ATM_ASSIGNMENT.src.atm_assignment;

public class BankACC {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String password;

    public BankACC(String accountId, String accountHolderName, double initialBalance, String password) {
        this.accountNumber = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.password = password;
    }

    public String getAccountId() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal complete. New balance = " + balance);
        }
    }
}
