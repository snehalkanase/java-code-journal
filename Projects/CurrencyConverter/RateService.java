package CurrencyConverter;

import java.util.HashMap;

public class RateService {
    private static final HashMap<String, Double> rates = new HashMap<>();

    static {
        rates.put("USD", 1.0);
        rates.put("EUR", 1.1515);
        rates.put("GBP", 1.3095);
        rates.put("JPY", 0.00639);
        rates.put("CHF", 1.2369);
        rates.put("CNY", 0.1408);
        rates.put("INR", 89.64);
    }

    public static Double getRate(String currency){
        try{
            if(checkCurrency(currency)){
                return rates.get(currency);
            }else {
                System.out.println("Currency not found: " + currency);
                return null;
            }
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static boolean checkCurrency(String currency){
        return rates.containsKey(currency);
    }

}
