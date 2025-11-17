package AtmMachine;

import java.util.Scanner;

public class LoginService {
    private final Scanner sc = new Scanner(System.in);
    private final AccountRepository repo = new AccountRepository();
    private final ATMMenu atmMenu= new ATMMenu();

    public void start(){
        System.out.println("Welcome to the ATM Machine System");

        while (true) {
            System.out.println("Enter your Account Number: ");
            int accountNumber = sc.nextInt();

            System.out.println("Enter your Password: ");
            int password = sc.nextInt();

            Account account = repo.authenticate(accountNumber, password);

            if(account != null){
                System.out.println("You have successfully logged in");
                atmMenu.startMenu(account);
            }else {
                System.out.println("Invalid Account Number or Password, try again.\\n");
            }
        }
    }
}


