package CurrencyConverter;

public class ConverterService {

    private static RateService rateService = new RateService();

    public static Double convert(String currency, String targetCurrency, Double amount) {
        double currentRate = rateService.getRate(currency);
        double targetRate = rateService.getRate(targetCurrency);
        return (amount / currentRate) * targetRate;
    }
}
