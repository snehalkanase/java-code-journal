package AtmMachine;

import java.util.HashMap;
import java.util.Scanner;

public class Login extends Account{
    private final Scanner input = new Scanner(System.in);
    private HashMap<Integer,Integer> accounts = new HashMap<>();
    boolean exit = false;
    public void loginToAccount(){
        accounts.put(98979695, 9897);
        accounts.put(88878685, 8887);
        do{
            System.out.println("Welcome to the Account Management System");
            System.out.println("Please enter your Account Number: ");
            int accNumber = input.nextInt();
            System.out.println("Please enter your Password: ");
            int pass = input.nextInt();

            if(accounts.containsKey(accNumber) && accounts.get(accNumber)==pass){
                System.out.println("You logged in Successfully");
                setAccountNumber(accNumber);
                setPassword(pass);
                getAccountType();
            } else{
                System.out.println("Sorry, invalid Account Number");
            }
        }while(!exit);
    }
    private void getAccountType(){
        System.out.println("Please select account you want to access ");
        System.out.println("Type 1 : Checking Account");
        System.out.println("Type 2 : Saving Account");
        System.out.println("Type 3 : Exit");
        System.out.println("Choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                break;
        }
    }
    public void getChecking(){
        System.out.println("Please Select the action you want to perform: ");
        System.out.println("Type 1 : View Balance");
        System.out.println("Type 2 : Withdraw Fund");
        System.out.println("Type 3 : Deposit Fund");
        System.out.println("Type 4 : Exit");
        System.out.println("Choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println("Your checking account balance is " + getCheckingAccountBalance());
                getChecking();
            case 2:
                System.out.println("Please enter your amount to withdraw: ");
                double amount = input.nextDouble();
                System.out.println("Now, Your Checking account balance is " + withdrawCheckingAccountBalance(amount));
                getChecking();
            case 3:
                System.out.println("Please enter your amount to deposit: ");
                double deposit = input.nextDouble();
                System.out.println("Now your checking account balance is " + depositCheckingAccountBalance(deposit));
                getChecking();
            case 4:
                getAccountType();
        }
    }

    public void getSaving(){
        System.out.println("Please Select the action you want to perform: ");
        System.out.println("Type 1 : View Balance");
        System.out.println("Type 2 : Withdraw Fund");
        System.out.println("Type 3 : Deposit Fund");
        System.out.println("Type 4 : Exit");
        System.out.println("Choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
                System.out.println("Your saving account balance is " + getSavingAccountBalance());
                getSaving();
            case 2:
                System.out.println("Please enter your amount to withdraw: ");
                double amount = input.nextDouble();
                System.out.println("Now, your saving account balance is " + withdrawSavingAccountBalance(amount));
                getSaving();
            case 3:
                System.out.println("Please enter your amount to deposit: ");
                double deposit = input.nextDouble();
                System.out.println("Now, your saving account balance is " + depositSavingAccountBalance(deposit));
                getSaving();
            case 4:
                getAccountType();

        }
    }
}
