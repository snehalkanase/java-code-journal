package AtmMachine;

public abstract class Account {
    protected Integer accountNumber;
    protected Integer password;
    protected double balance;

    public Account(Integer accountNumber, Integer password){
        this.accountNumber = accountNumber;
        this.password = password;
    }
    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Integer getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient funds");
            return false;
        }
         if(amount <= 0){
             System.out.println("Amount must be positive");
             return false;
         }
         balance -= amount;
         return true;
    }

    public void deposit(double amount){
        if(amount < balance){
            System.out.println("Account must be positive");
            return;
        }
        balance += amount;
    }

    public abstract String getAccountType();

    //    private int accountNumber;
//    private int password;
//    private double checkingAccountBalance = 0;
//    private double savingAccountBalance = 0;
//
//    public Account(int accountNumber, int password) {
//        this.accountNumber = accountNumber;
//        this.password = password;
//    }
//    // saving account details
//    public double getSavingAccountBalance() {
//        return savingAccountBalance;
//    }
//    public double withdrawSavingAccountBalance(double amount){
//        if(amount > savingAccountBalance){
//            System.out.println("Insufficient funds.");
//            return savingAccountBalance;
//        }
//        savingAccountBalance -= amount;
//        return savingAccountBalance;
//    }
//    public double depositSavingAccountBalance(double amount){
//        return savingAccountBalance += amount;
//    }
//    //checking account details
//    public double getCheckingAccountBalance() {
//        return checkingAccountBalance;
//    }
//    public double withdrawCheckingAccountBalance(double amount) {
//        if(amount > checkingAccountBalance) {
//            System.out.println("Insufficient funds.");
//            return checkingAccountBalance;
//        }
//        checkingAccountBalance -= amount;
//        return checkingAccountBalance;
//    }
//    public double depositCheckingAccountBalance(double amount) {
//       return checkingAccountBalance += amount;
//    }
//    public void setAccountNumber(int accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//    public void setPassword(int password) {
//        this.password = password;
//    }
}
