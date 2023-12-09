package by.andd3dfx.numeric;

/**
 * <pre>
 * Given an integer n, return true if it is a power of k. Otherwise, return false.
 *
 * An integer n is a power of k, if there exists an integer x such that n == k^x.
 *
 * Example 1:
 *
 * Input: n = 64, k = 4
 * Output: true
 * Explanation: 64 = 4^3
 *
 * Example 2:
 *
 * Input: n = 0, k = 3
 * Output: false
 * Explanation: There is no x where 3^x = 0.
 *
 * Example 3:
 *
 * Input: n = -1, k = 2
 * Output: false
 * Explanation: There is no x where 2^x = (-1).
 * </pre>
 */
public class PowerOfK {

    public static boolean isPowerOfK(int n, int k) {
        while (n > 0 && n % k == 0) {
            n /= k;
        }
        return n == 1;
    }

    /**
     * n = k^x => log_k (n) = x
     * log_a (b) = ln(b) /ln(a) = lg(b)/lg(a)
     */
    public static boolean isPowerOfK_usingLog(int n, int k) {
        if (n <= 0) {
            return false;
        }
        var power = Math.round(Math.log(n) / Math.log(k));
        return Math.pow(k, power) == n;
    }
}
