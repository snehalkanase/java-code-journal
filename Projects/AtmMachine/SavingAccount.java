package AtmMachine;

public class SavingAccount extends Account {

    public SavingAccount(Integer accountNumber, Integer password){
        super(accountNumber, password);
    }

    @Override
    public String getAccountType() {
        return "Saving Account";
    }
}