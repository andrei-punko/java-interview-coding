package by.andd3dfx.numeric;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/maximum-swap/">Task description</a>
 *
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you can get.
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 * </pre>
 *
 * @see <a href="https://youtu.be/-my6feBZ6RY">Video solution</a>
 */
public class MaximumSwap {

    public static int solve(int num) {
        var digits = numToDigits(num);

        for (var i = 0; i < digits.length; i++) {
            var maxIndex = i;
            for (var j = i + 1; j < digits.length; j++) {
                if (digits[maxIndex] < digits[j] || (digits[maxIndex] == digits[j] && maxIndex != i)) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                swap(digits, i, maxIndex);
                return digitsToNum(digits);
            }
        }
        return num;
    }

    private static int[] numToDigits(int num) {
        var str = String.valueOf(num);
        int[] digits = new int[str.length()];

        var pos = 0;
        for (var digit : str.toCharArray()) {
            digits[pos++] = digit - '0';
        }
        return digits;
    }

    private static int digitsToNum(int[] digits) {
        int result = 0;
        for (int digit : digits) {
            result = 10 * result + digit;
        }
        return result;
    }

    private static void swap(int[] items, int i, int j) {
        var tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
