package BankingApplication.src.service.impl;

import BankingApplication.src.exceptions.AccountNotFoundException;
import BankingApplication.src.exceptions.InsufficientFundsException;
import BankingApplication.src.repository.AccountRepository;
import BankingApplication.src.repository.CustomerRepository;
import BankingApplication.src.repository.TransactionRepository;
import BankingApplication.src.service.BankService;
import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.Type;
import exceptions.ValidationException;
import util.Validation;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {
    private AccountRepository accountRepository = new AccountRepository();
    private TransactionRepository transactionRepository = new TransactionRepository();
    private CustomerRepository customerRepository = new CustomerRepository();

    private final Validation<String> validateName = name ->{
        if(name == null || name.isBlank()) throw new ValidationException("Name is required");
    };
    private final Validation<String> validateEmail = email ->{
        if(email == null || !email.contains("@")) throw new ValidationException("Valid Email is required");
    };

    private final Validation<String> validateType = type ->{
        if(type == null || !(type.equalsIgnoreCase("SAVINGS") || type.equalsIgnoreCase("CURRENT")))
            throw new ValidationException("Type is required");
    };

    @Override
    public String openBankAccount(String name, String email, String accountType) {
        validateName.validate(name);
        validateEmail.validate(email);
        validateType.validate(accountType);

        String customerId = getRandomId();
        Customer cutomer = new Customer(customerId, name, email);
        customerRepository.save(cutomer);
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, customerId, 0, accountType );
        //save this account created
        accountRepository.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, double amount, String depositNote) {
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found " + accountNumber));
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited");
        String transactionId = getRandomId();
        Transaction transaction = new Transaction(transactionId, account.getAccountNumber(),amount,
                LocalDateTime.now(),depositNote, Type.DEPOSIT);
        transactionRepository.add(transaction);
    }

    @Override
    public void withdraw(String accountNumber, double amount, String withdrawNote) {
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found " + accountNumber));
        if(account.getBalance() < amount)
            throw new InsufficientFundsException("Insufficient Balance");
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw");
        String transactionId = getRandomId();
        Transaction transaction = new Transaction(transactionId, account.getAccountNumber(),amount,
                LocalDateTime.now(),withdrawNote, Type.WITHDRAW);
        transactionRepository.add(transaction);
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount, String transferNote) {
        if(fromAccountNumber.equals(toAccountNumber))
            throw new RuntimeException("You can not transfer money to your account");
        Account fromAccount = accountRepository.findByNumber(fromAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found " + fromAccountNumber));
        Account toAccount = accountRepository.findByNumber(toAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found " + toAccountNumber));

        if(fromAccount.getBalance() < amount)
            throw new InsufficientFundsException("Insufficient Balance");

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        System.out.println("Transfer");

        String fromTransactionId = getRandomId();
        Transaction fromTransaction = new Transaction(fromTransactionId, fromAccount.getAccountNumber(),amount,
                LocalDateTime.now(), transferNote, Type.TRANSFER_OUT);
        String toTransactionId = getRandomId();
        Transaction toTransaction = new Transaction(toTransactionId, toAccount.getAccountNumber(),amount,
                LocalDateTime.now(), transferNote, Type.TRANSFER_IN);
        transactionRepository.add(fromTransaction);
        transactionRepository.add(toTransaction);
    }

    @Override
    public List<Transaction> statement(String accountNumber) {
        return transactionRepository.getTransactions(accountNumber)
                .stream()
                .sorted(Comparator.comparing(Transaction::getTimeStamp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> searchAccountsByCustomerName(String customerName) {
        String query = customerName == null ? "" : customerName.toLowerCase();
//        List<Account> result = new ArrayList<>();
//        for(Customer c : customerRepository.findAll()){
//            if(c.getName().toLowerCase().contains(query)){
//                result.addAll(accountRepository.findByCustomerId(c.getId()));
//            };
//        }
//        result.sort(Comparator.comparing(Account::getAccountNumber));
//        return result;

        return customerRepository.findAll()
                .stream()
                .filter((c) -> c.getName().toLowerCase().contains(query))
                .flatMap(c-> accountRepository.findByCustomerId(c.getId())
                        .stream())
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    private String getAccountNumber() {
        int size = accountRepository.findAll().size() + 1;
        return String.format("AC%06d",  size);
    }
    private String getRandomId(){
        return UUID.randomUUID().toString();
    }
}
