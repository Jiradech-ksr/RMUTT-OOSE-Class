package atm_assignment;

public class Account extends Person implements ATMAction {
    private String username;
    private String password;
    private double balance;

    public Account(String idCard, String fullName, String gender,
                   String username, String password, double balance) {
        super(idCard, fullName, gender);
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdraw success. Balance = " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.println("Deposit success. Balance = " + balance);
        }
    }

    @Override
    public void transfer(Account target, double amount) {
        if (target == null) {
            System.out.println("Target account not found.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            target.balance += amount;
            System.out.println("Transfer success. Your balance = " + balance);
        }
    }
}
