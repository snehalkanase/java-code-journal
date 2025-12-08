package BankingApplication.src.repository;

import domain.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TransactionRepository {
    private final HashMap<String, List<Transaction>> transactions = new HashMap<>();

    public void add(Transaction transaction){
       List<Transaction> list =  transactions.computeIfAbsent(transaction.getAccountNumber(),
               k -> new ArrayList<>());
       list.add(transaction);
    }
    public List<Transaction> getTransactions(String accountNumber){
        return new ArrayList<>(transactions.getOrDefault(accountNumber, Collections.emptyList()));
    }
}
