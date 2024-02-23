import java.util.Scanner;

public class Codsoft_03 {
    private BankAccount account;
    private Scanner scanner;

    public Codsoft_03(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount))
            System.out.println("Withdrawal successful.");
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        Codsoft_03 atm = new Codsoft_03(userAccount);
        atm.start();
    }
}
