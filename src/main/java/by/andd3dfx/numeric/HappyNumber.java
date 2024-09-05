package by.andd3dfx.numeric;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/happy-number/description/">Task description</a>
 *
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 *     Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *     Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 *   Input: n = 19
 *   Output: true
 *   Explanation:
 *   12 + 92 = 82
 *   82 + 22 = 68
 *   62 + 82 = 100
 *   12 + 02 + 02 = 1
 *
 * Example 2:
 *   Input: n = 2
 *   Output: false
 * </pre>
 *
 * @see <a href="https://youtu.be/9viwbL63DnU">Video solution</a>
 */
public class HappyNumber {

    public static boolean isHappyUsingMemory(int n) {
        Set<Integer> numbers = new HashSet<>();

        var tmp = sumOfDigitSquares(n);
        while (tmp != 1 && numbers.add(tmp)) {
            tmp = sumOfDigitSquares(tmp);
        }
        return tmp == 1;
    }

    public static boolean isHappyUsing2Pointers(int n) {
        var p1 = sumOfDigitSquares(n);
        var p2 = sumOfDigitSquares(p1);

        do {
            // p1: 1 step
            p1 = sumOfDigitSquares(p1);

            // p2: 2 steps
            p2 = sumOfDigitSquares(p2);
            if (p1 == p2) {
                return p1 == 1;
            }
            p2 = sumOfDigitSquares(p2);
            if (p1 == p2) {
                return p1 == 1;
            }
        } while (true);
    }

    private static int sumOfDigitSquares(int n) {
        var result = 0;
        while (n > 0) {
            var remainder = n % 10;
            result += remainder * remainder;
            n /= 10;
        }
        return result;
    }
}
