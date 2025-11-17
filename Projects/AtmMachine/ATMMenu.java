package AtmMachine;

import java.util.Scanner;

public class ATMMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void startMenu(Account account){
        while(true){
            System.out.println("\n---- " + account.getAccountType() + " ----");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = readInt();

            switch (choice){
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Please enter your amount to withdraw: ");
                    double amount = readDouble();
                    if(account.withdraw(amount)){
                        System.out.println("Withdraw Successful, current balance is $" + account.getBalance());
                    }
                    break;
                case 3:
                    System.out.println("Please enter your amount to deposit: ");
                    double depositAmount = readDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit Successful, current balance is $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Logout Successful");
                    return;
                default:
                        System.out.println("Invalid choice, try again.");
            }
        }
    }

    public int readInt(){
        while(!scanner.hasNextInt()){
            System.out.println("Please enter a valid number");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public double readDouble(){
        while(!scanner.hasNextDouble()){
            System.out.println("Please enter a valid number");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
