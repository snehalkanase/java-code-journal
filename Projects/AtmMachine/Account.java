package AtmMachine;

public class Account {
    private int accountNumber;
    private int password;
    private double checkingAccountBalance = 0;
    private double savingAccountBalance = 0;

    // saving account details
    public double getSavingAccountBalance() {
        return savingAccountBalance;
    }
    public double withdrawSavingAccountBalance(double amount){
        if(amount > savingAccountBalance){
            System.out.println("Insufficient funds.");
            return savingAccountBalance;
        }
        savingAccountBalance -= amount;
        return savingAccountBalance;
    }
    public double depositSavingAccountBalance(double amount){
        return savingAccountBalance += amount;
    }
    //checking account details
    public double getCheckingAccountBalance() {
        return checkingAccountBalance;
    }
    public double withdrawCheckingAccountBalance(double amount) {
        if(amount > checkingAccountBalance) {
            System.out.println("Insufficient funds.");
            return checkingAccountBalance;
        }
        checkingAccountBalance -= amount;
        return checkingAccountBalance;
    }
    public double depositCheckingAccountBalance(double amount) {
       return checkingAccountBalance += amount;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setPassword(int password) {
        this.password = password;
    }
}
