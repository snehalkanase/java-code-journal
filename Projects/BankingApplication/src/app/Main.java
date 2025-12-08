package app;

import BankingApplication.src.service.BankService;
import BankingApplication.src.service.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankServiceImpl bankService = new BankServiceImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Banking Application");
        boolean running = true;
        while (running) {
            System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdraw
                4) Transfer
                5) Account Statement
                6) List Accounts
                7) Search Account by Customer name
                0) Exit 
                """);
            System.out.print("CHOICE : ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "0" -> running = false;
                case "1" -> openBankAccount(input, bankService);
                case "2" -> depositAmount(input, bankService);
                case "3" -> withdrawAmount(input, bankService);
                case "4" -> transferAmount(input, bankService);
                case "5" -> statement(input, bankService);
                case "6" -> listAccounts(input, bankService);
                case "7" -> searchAccounts(input, bankService);
            }
        }
    }

    private static void searchAccounts(Scanner input, BankService bankService) {
        System.out.print("Customer name contains: ");
        String name = input.nextLine().trim();
        bankService.searchAccountsByCustomerName(name).forEach(account ->
                System.out.println(account.getAccountNumber() + " | " + account.getAccountType() + " | " + account.getBalance())
        );
    }

    private static void statement(Scanner input, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = input.nextLine().trim();
        bankService.statement(accountNumber).forEach(t -> {
            System.out.println(t.getTimeStamp() + " | " + t.getType() + " | " + t.getAmount() + " | " + t.getNote());
        });
    }

    private static void transferAmount(Scanner input,BankService bankService) {
        System.out.print("From Account number: ");
        String fromAccountNumber = input.nextLine().trim();
        System.out.print("To Account number: ");
        String toAccountNumber = input.nextLine().trim();
        System.out.print("Amount: ");
        double amount = Double.parseDouble(input.nextLine().trim());
        bankService.transfer(fromAccountNumber, toAccountNumber, amount, "Transfer");
    }

    private static void withdrawAmount(Scanner input, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = input.nextLine().trim();
        System.out.print("Amount to withdraw: ");
        Double amount = Double.parseDouble(input.nextLine().trim());
        bankService.withdraw(accountNumber, amount, "Withdraw");
    }

    private static void depositAmount(Scanner input, BankService bankService ) {
        System.out.print("Account Number: ");
        String accountNumber = input.nextLine().trim();
        System.out.print("Amount : ");
        String amount = input.nextLine().trim();
        Double depositAmount = Double.parseDouble(amount);
        bankService.deposit(accountNumber,depositAmount, "Deposit");
    }

    private static void openBankAccount(Scanner input, BankService bankService) {
        System.out.print("Customer name: ");
        String name = input.nextLine().trim();
        System.out.print("Customer email: ");
        String email = input.nextLine().trim();
        System.out.print("Account Type (SAVINGS/CURRENT): ");
        String type = input.nextLine().trim();
        System.out.print("Initial Deposit Amount: ");
        String amount = input.nextLine().trim();
        if(amount.isBlank()) amount = "0";
        Double initialDepositAmount = Double.parseDouble(amount);
        String accountNumber = bankService.openBankAccount(name, email, type);
        if(initialDepositAmount > 0){
            bankService.deposit(accountNumber, initialDepositAmount, "Initial Deposit Amount");
        }
        System.out.println("Account opened " + accountNumber);
    }

    private static void listAccounts(Scanner input, BankService bankService) {
        bankService.listAccounts().forEach(a -> {
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | "+ a.getBalance());
        });
    }
}
