package by.andd3dfx.numeric;

/**
 * https://leetcode.com/problems/palindrome-number/
 * <p>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        var chars = String.valueOf(x).toCharArray();
        var len = chars.length;
        for (var i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
