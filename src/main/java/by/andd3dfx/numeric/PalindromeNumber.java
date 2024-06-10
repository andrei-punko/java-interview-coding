package by.andd3dfx.numeric;

/**
 * https://leetcode.com/problems/palindrome-number/
 * <p>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        var chars = String.valueOf(x).toCharArray();
        var left = 0;
        var right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
