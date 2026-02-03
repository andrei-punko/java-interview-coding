package by.andd3dfx.string;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/consecutive-characters/">Task description</a>
 *
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Given a string s, return the power of s.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 *
 * Example 2:
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * </pre>
 */
public class ConsecutiveCharacters {

    public static int maxPower(String s) {
        var n = s.length();
        char[] chars = s.toCharArray();

        var left = 0;
        var right = 0;
        var max = 1;
        while (right < n - 1) {
            right++;
            if (chars[left] != chars[right]) {
                left = right;
            }

            var curr = right - left + 1;
            if (curr > max) {
                max = curr;
            }
        }

        return max;
    }
}
