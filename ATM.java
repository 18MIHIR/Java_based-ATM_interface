import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the ATM Interface");
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        if (authenticateUser(userId)) {
            int choice;
            do {
                showMenu();
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        account.showTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println("Thank you for using ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private boolean authenticateUser(String userId) {
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        return account.getUserId().equals(userId) && pin == 1234; // Simple authentication
    }

    private void showMenu() {
        System.out.println("\n------ ATM Menu ------");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.println("----------------------");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void transfer() {
        sc.nextLine(); // consume newline
        System.out.print("Enter receiver name: ");
        String receiverName = sc.nextLine();
        System.out.print("Enter receiver ID: ");
        String receiverId = sc.nextLine();
        System.out.print("Enter amount to transfer: ₹");
        double amount = sc.nextDouble();

        BankAccount receiver = new BankAccount(receiverName, receiverId);
        account.transfer(receiver, amount);
    }
}
