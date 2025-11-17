package AtmMachine;

import java.util.HashMap;

public class AccountRepository {

    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public AccountRepository() {
        accounts.put(1001, new CheckingAccount(1001, 1111));
        accounts.put(1002, new SavingAccount(1002, 2222));
    }

    public Account authenticate(Integer accountNumber, Integer password){
        Account account = accounts.get(accountNumber);
        if(account != null && account.getPassword().equals(password)){
            return account;
        }
        return null;
    }
}
