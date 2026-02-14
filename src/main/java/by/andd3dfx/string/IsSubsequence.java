package by.andd3dfx.string;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/is-subsequence/description/">Task description</a>
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *   Input: s = "abc", t = "ahbgdc"
 *   Output: true
 *
 * Example 2:
 *   Input: s = "axc", t = "ahbgdc"
 *   Output: false
 * </pre>
 *
 * @see <a href="https://youtu.be/UbXVhH4NIuQ">Video solution</a>
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        var last = -1;
        for (var ch : s.toCharArray()) {
            var index = t.indexOf(ch, last + 1);
            if (index == -1) {
                return false;
            }
            last = index;
        }
        return true;
    }
}
