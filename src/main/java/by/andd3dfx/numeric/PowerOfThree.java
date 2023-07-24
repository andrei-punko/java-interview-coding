package by.andd3dfx.numeric;

/**
 * <pre>
 * https://leetcode.com/problems/power-of-three/description/
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * Example 1:
 *
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 3^3
 *
 * Example 2:
 *
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3^x = 0.
 *
 * Example 3:
 *
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3^x = (-1).
 * </pre>
 */
public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree_usingLog(int n) {
        if (n <= 0) {
            return false;
        }
        var power = Math.round(Math.log(n) / Math.log(3));
        return Math.pow(3, power) == n;
    }
}
