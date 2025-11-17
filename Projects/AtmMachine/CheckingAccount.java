package AtmMachine;

public class CheckingAccount extends Account {

    CheckingAccount(Integer accountNumber, Integer password){
        super(accountNumber, password);
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }
}
