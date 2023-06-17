
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;
    private int recipientAccountNumber;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public Transaction(String type, double amount, int recipientAccountNumber) {
        this.type = type;
        this.amount = amount;
        this.recipientAccountNumber = recipientAccountNumber;
    }

    public String toString() {
        if (type.equals("Transfer")) {
            return String.format("%s: $%.2f to Account %d", type, amount, recipientAccountNumber);
        } else {
            return String.format("%s: $%.2f", type, amount);
        }
    }
}

class ATM {
    private int userId;
    private int pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public ATM() {
        this.userId = 7894;
        this.pin = 1456;
        this.balance = 10000000.0;
        this.transactionHistory = new ArrayList<>();
    }

    void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.toString());
        }
    }

    boolean authenticate(int userId, int pin) {
        return (this.userId == userId && this.pin == pin);
    }

    void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal Successful");
 System.out.println("Current balance is "+this.balance);
            Transaction t = new Transaction("Withdraw", amount);
            transactionHistory.add(t);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit Successful");
            System.out.println("Updated balance is "+this.balance);
            Transaction t = new Transaction("Deposit", amount);
            transactionHistory.add(t);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void transfer(double amount, int recipientAccountNumber) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Transfer Successful");
System.out.println("Current balance is "+this.balance);
            Transaction t = new Transaction("Transfer", amount, recipientAccountNumber);
            transactionHistory.add(t);
        } else {
            System.out.println("Insufficient Balance for transfer");
        }
    }
}

class ATMmain {
    public static void main(String Args[]) {

        System.out.println("*************WELCOME TO ATM*************");

        Scanner scanner = new Scanner(System.in);
        ATM user = new ATM();
        System.out.println("Enter userId:");
        int userId = scanner.nextInt();
        System.out.println("Enter ATM pin:");
        int pin = scanner.nextInt();
        if (user.authenticate(userId, pin)) {
            System.out.println("\nAuthentication successful!");
            boolean quit = false;
            while (!quit) {
                System.out.println("\nSelect from the following options:\n");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Transfer");
                System.out.println("4. Quit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter amount to be withdrawn");
                        double amt = scanner.nextDouble();
                        user.withdraw(amt);
                        break;

                    case 2:
                        System.out.println("Enter amount to be deposited");
                        double amt1 = scanner.nextDouble();
                        user.deposit(amt1);
                        break;

                    case 3:
                        System.out.println("Enter amount to be transferred");
                        double amt2 = scanner.nextDouble();
                        System.out.println("Enter recipient's account number: ");
                        int recipientAccountNumber = scanner.nextInt();
                        user.transfer(amt2, recipientAccountNumber);
                        break;

                    case 4:
                        quit = true;
                        break;

                    default:
                        System.out.println("Invalid option");
                }
            }
        } else {
            System.out.println("Authentication unsuccessful !");
        }
        System.out.println("****************Thank you****************");
    }
}
