import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("Mihir", "123456");
        ATM atm = new ATM(account);
        atm.run();
        sc.close();
    }
}
