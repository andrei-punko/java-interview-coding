package by.andd3dfx.string;

import java.util.regex.Pattern;

/**
 * <pre>
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * </pre>
 *
 * @see <a href="https://youtu.be/Kev5TpsfKT4">Video solution</a>
 */
public class LengthOfLastWord {

    public int determine(String s) {
        s = s.trim();

        int spaceIndex = -1;
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceIndex = i;
            }
        }

        return s.length() - spaceIndex - 1;
    }

    public int determineWithoutTrim(String s) {
        var right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }

        var left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }

        return right - left;
    }

    private final static Pattern PATTERN = Pattern.compile("\\w+(?=\\s*$)");

    public int determineUsingRegex(String s) {
        var matcher = PATTERN.matcher(s);
        matcher.find();

        return matcher.end() - matcher.start();
    }
}
