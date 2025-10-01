package PasswordGenerator;

import java.util.Random;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_SYMBOLS = "!@#$%^&*()_+{}[]|:;<>,./?`~";

    private final Random random;

    public PasswordGenerator() {
        random = new Random();
    }

    public String generatePassword(int length, boolean includeUppercase,boolean includeLowercase ,boolean includeNumbers,
                                   boolean includeSpecialSymbols) {
        StringBuffer passwordBuilder = new StringBuffer();

        String validString = "";

        if(includeUppercase) validString += UPPERCASE_CHARACTERS;
        if(includeLowercase) validString += LOWERCASE_CHARACTERS;
        if(includeNumbers) validString += NUMBERS;
        if(includeSpecialSymbols) validString += SPECIAL_SYMBOLS;

        for(int i = 0; i < length; i++){
            int randomIndex = random.nextInt(validString.length());
            char randomChar = validString.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }
}
