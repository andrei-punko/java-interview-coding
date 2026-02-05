package by.andd3dfx.numeric;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/palindrome-number/">Task description</a>
 *
 * Given an integer x, return true if x is a , and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * </pre>
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        char[] digits = String.valueOf(x).toCharArray();
        var n = digits.length;
        for (int i = 0; i < n / 2; i++) {
            if (digits[i] != digits[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int n = (int) Math.log10(x) + 1;
        int[] digits = new int[n];

        var curr = 0;
        while (x > 0) {
            digits[curr] = x % 10;
            curr++;
            x /= 10;
        }

        for (int i = 0; i < n / 2; i++) {
            if (digits[i] != digits[n - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
