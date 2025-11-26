package CurrencyConverter;

import java.util.Scanner;

public class App {
    private static Scanner input  = new Scanner(System.in);
    private static boolean isCheckAgain = true;
    private static RateService rateService = new RateService();
    public static void main(String[] args) {
        System.out.println("Welcome to Currency Converter");

        while (isCheckAgain) {
            convert();
            isCheckAgain();
        }
    }
    private static void convert() {
        System.out.println("Please enter your currency (INR/USD/EUR/GBP/JPY/CHF/CNY) : ");
        String currency = checkCurrency();
        System.out.println("Please enter your target currency (INR/USD/EUR/GBP/JPY/CHF/CNY) : ");
        String targetCurrency = checkCurrency();
        System.out.println("Please enter the amount to be converted into Currency: ");
        Double amount = input.nextDouble();
        input.nextLine();

        double convertedAmount = ConverterService.convert(currency, targetCurrency, amount);
        System.out.println("Your converted amount is: " + convertedAmount);
    }
    private static void isCheckAgain() {
        System.out.println("Do you want to check again (Y/N) : ");
        if(input.hasNext()){
            if (input.nextLine().equalsIgnoreCase("Y")) {
                isCheckAgain = true;
            } else  {
                isCheckAgain = false;
            }
        }
    }

    private static String checkCurrency(){
        String code;
        while (true) {
            code = input.nextLine().trim().toUpperCase();
            if (rateService.checkCurrency(code)) {
                return code;
            }
            System.out.println("Currency not supported. Please enter again:");
        }
    }
}
