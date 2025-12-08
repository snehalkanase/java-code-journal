package BankingApplication.src.service;
import domain.Account;
import domain.Transaction;
import java.util.List;

public interface BankService {
    String openBankAccount(String name, String email, String accountType);
    List<Account> listAccounts();
    void deposit(String accountNumber, double amount, String depositNote);
    void withdraw(String accountNumber, double amount, String withdrawNote);
    void transfer(String fromAccountNumber, String toAccountNumber, double amount, String transferNote);
    List<Transaction> statement(String accountNumber);
    List<Account> searchAccountsByCustomerName(String customerName);
}
