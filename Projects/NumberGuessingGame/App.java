package NumberGuessingGame;

import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    private static int attempt = 0;
    private static boolean isCorrect = false;
    private static int systemNumber;

    public static void main(String[]args){
        System.out.println("Welcome to Number Guessing Game");
        systemNumber = systemGenerateNumber();
        while (!isCorrect){
            int userNumber = userInput();
            if(userNumber != 0){
                attempt++;
                checker(userNumber, systemNumber);
            }
        }
    }

    private static int userInput(){
        System.out.println("Please enter the number you would like to guess between 1 - 50:");
        int userNumber = input.nextInt();
            if(userNumber < 1 || userNumber > 50){
                System.out.println("Number must be between 1 and 50");
                return 0;
            }
        return userNumber;
    }

    private static int systemGenerateNumber(){
        int number = (int) (Math.random() * 50) + 1;
        return number;
    }
    private static void checker(int userNumber, int systemNumber){
        if(userNumber == systemNumber){
            System.out.println("You guessed correctly " + systemNumber + " ! in " + attempt + " attempts");
            playAgain();
        }else if(userNumber < systemNumber){
            System.out.println("Too Low!");
            isCorrect = false;
        }else if(userNumber > systemNumber){
            System.out.println("Too High!");
            isCorrect = false;
        }
    }
    private static boolean playAgain(){
        System.out.println("Would you like to play again? y/n :");
        boolean playAgain = input.next().equalsIgnoreCase("y");
        if(playAgain){
            attempt = 0;
            systemNumber = systemGenerateNumber();
            isCorrect = false;
        }else {
            isCorrect = true;
        }
        return playAgain;
    }
}
