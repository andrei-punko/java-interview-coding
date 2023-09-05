package by.andd3dfx.numeric;

/**
 * <pre>
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *  Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 * </pre>
 */
public class SumOfTwoIntegersWithoutUsingPlusMinus {

    public static int getSum(int a, int b) {
        int res = a;

        for (var pos = 0; pos < 32; pos = incNthBit(pos, 0)) {  // To avoid using `++` in expression :)
            if ((b & (1 << pos)) != 0) {
                res = incNthBit(res, pos);
            }
        }

        return res;
    }

    static int incNthBit(int number, int n) {
        var shifted_1 = 1 << n;
        if ((number & shifted_1) == 0) {
            return number | shifted_1;
        }

        number ^= shifted_1;
        var n_plus_1 = incNthBit(n, 0);     // To avoid using `+` in `n+1` expression :)
        return incNthBit(number, n_plus_1);
    }
}
