package by.andd3dfx.numeric;

/**
 * <pre>
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * Write a function that takes the binary representation of a positive integer and returns
 * the number of set bits it has (also known as the Hamming weight).
 *
 * Example 1:
 *   Input: n = 11
 *   Output: 3
 *   Explanation:
 *   The input binary string 1011 has a total of three set bits.
 *
 * Example 2:
 *   Input: n = 128
 *   Output: 1
 *   Explanation:
 *   The input binary string 10000000 has a total of one set bit.
 *
 * Example 3:
 *   Input: n = 2147483645
 *   Output: 30
 *   Explanation:
 *   The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 * </pre>
 *
 * @see <a href="https://youtu.be/F8zwvJYw0R8">Video solution</a>
 */
public class CountOnesInBinaryForm {

    /**
     * 0b100011 -> 0b10001 -> 0b1000 -> 0b100 -> ... -> 0
     */
    public static int count(int num) {
        int result = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                result++;
            }
            num = num >> 1;
        }
        return result;
    }
}
