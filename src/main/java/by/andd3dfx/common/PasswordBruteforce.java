package by.andd3dfx.common;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

/**
 * We have an alphabet of characters and hash function.
 * Write decode() function which gets hash value and restore password by this hash.
 * Password contains only characters from the given alphabet.
 */
public class PasswordBruteforce {

    private final String alphabet;
    private final Function<String, String> hashFunction;
    private final String ZERO_CHARACTER = "☺";

    public PasswordBruteforce(char[] alphabet, Function<String, String> hashFunction) {
        this.alphabet = ZERO_CHARACTER + new String(alphabet);
        this.hashFunction = hashFunction;
    }

    public String decode(String passwordHash, int maxPasswordLength) {
        double maxNumber = Math.pow(alphabet.length(), maxPasswordLength);

        int number = 1;
        while (number < maxNumber) {
            var password = encode(number);
            String hash = hashFunction.apply(password);

            if (StringUtils.equals(hash, passwordHash) && !password.contains(ZERO_CHARACTER)) {
                return password;
            }
            number++;
        }
        return null;
    }

    String encode(int value) {
        String result = "";
        while (value > 0) {
            var pos = value % alphabet.length();
            result = alphabet.charAt(pos) + result;
            value /= alphabet.length();
        }
        return result;
    }
}
