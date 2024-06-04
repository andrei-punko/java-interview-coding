package by.andd3dfx.numeric;

/**
 * <pre>
 * https://leetcode.com/problems/power-of-two/description/
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 *
 * Example 2:
 *
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 *
 * Input: n = 3
 * Output: false
 * Explanation: There is no x where 2^x = 3.
 * </pre>
 *
 * @see <a href="https://youtu.be/E1Gue5EcvK4">Video solution</a>
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        while (n > 0 && n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * n = 2^x => log_2 (n) = x
     * log_a (b) = ln(b) /ln(a) = lg(b)/lg(a)
     */
    public static boolean isPowerOfTwo_usingLog(int n) {
        if (n <= 0) {
            return false;
        }

        var power = Math.round(Math.log(n) / Math.log(2));
        return Math.pow(2, power) == n;
    }
}
