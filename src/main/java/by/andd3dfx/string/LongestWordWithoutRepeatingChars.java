package by.andd3dfx.string;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 *
 * @see <a href="https://youtu.be/Jj66XXja4LY">Video solution</a>
 */
public class LongestWordWithoutRepeatingChars {

    public static int determine(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        var chars = s.toCharArray();
        Set set = new HashSet();

        while (right < chars.length) {
            if (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            } else {
                set.add(chars[right]);
                right++;
                max = Math.max(max, set.size());
            }
        }

        return max;
    }
}
