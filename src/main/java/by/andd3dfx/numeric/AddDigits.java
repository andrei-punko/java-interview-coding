package by.andd3dfx.numeric;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/add-digits/description/">Task description</a>
 *
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 *
 * Example 2:
 *
 * Input: num = 0
 * Output: 0
 * </pre>
 *
 * @see <a href="https://youtu.be/04ezQ_--SIs">Video solution</a>
 */
public class AddDigits {

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        var sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return addDigits(sum);
    }

    /**
     * https://en.wikipedia.org/wiki/Digital_root
     */
    public static int addDigits_usingDigitalRoot(int num) {
        if (num == 0) {
            return 0;
        }

        var remainder = num % 9;
        if (remainder == 0) {
            return 9;
        }

        return remainder;
    }
}
