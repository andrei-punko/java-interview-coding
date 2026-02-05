package by.andd3dfx.numeric;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/palindrome-number/">Task description</a>
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * </pre>
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        var chars = String.valueOf(x).toCharArray();
        var n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
