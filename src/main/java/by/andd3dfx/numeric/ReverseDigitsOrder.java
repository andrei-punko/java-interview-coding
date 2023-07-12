package by.andd3dfx.numeric;

/**
 * <pre>
 * Revert order of digits in Integer number:
 * 0 -> 0
 * 12389 -> 98321,
 * 123490 -> 94321,
 * -123 -> -321
 * </pre>
 */
public class ReverseDigitsOrder {

    public static int usingString(int number) {
        var isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }

        var string = String.valueOf(number);
        var reversedString = new StringBuilder(string).reverse().toString();

        if (isNegative) {
            reversedString = "-" + reversedString;
        }

        return Integer.valueOf(reversedString);
    }

    public static int usingNumber(int number) {
        int result = 0;
        do {
            int digit = number % 10;
            result = result * 10 + digit;
            number /= 10;
        } while (number != 0);
        return result;
    }
}
