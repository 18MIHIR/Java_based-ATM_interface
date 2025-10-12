import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String userName;
    private String userId;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            receiver.balance += amount;
            transactionHistory.add("Transferred ₹" + amount + " to " + receiver.userName);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check balance or amount.");
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

