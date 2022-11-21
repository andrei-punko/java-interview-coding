package by.andd3dfx.numeric;

import org.apache.commons.lang3.StringUtils;

/**
 * Revert order of digits in Integer number: 12389->98321
 */
public class ReverseDigitsOrder {

    public static int usingString(int number) {
        String string = String.valueOf(number);
        String reversedString = StringUtils.reverse(string);
        return Integer.valueOf(reversedString);
    }

    public static int usingNumber(int number) {
        int result = 0;
        do {
            int digit = number % 10;
            result = result * 10 + digit;
            number /= 10;
        } while (number > 0);
        return result;
    }
}
