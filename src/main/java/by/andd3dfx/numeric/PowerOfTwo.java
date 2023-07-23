package by.andd3dfx.numeric;

/**
 * <pre>
 * https://leetcode.com/problems/power-of-two/description/
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
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
 * </pre>
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        while (n > 0 && n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
