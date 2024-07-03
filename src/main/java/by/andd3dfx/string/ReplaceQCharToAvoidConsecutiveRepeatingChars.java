package by.andd3dfx.string;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/">Task description</a>
 *
 * Given a string s containing only lowercase English letters and the '?' character, convert all the '?' characters
 * into lowercase letters such that the final string does not contain any consecutive repeating characters.
 * You cannot modify the non '?' characters.
 * It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
 * Return the final string after all the conversions (possibly zero) have been made. If there is more than one
 * solution, return any of them. It can be shown that an answer is always possible with the given constraints.
 *
 * Example 1:
 * Input: s = "?zs"
 * Output: "azs"
 * Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid.
 * Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
 *
 * Example 2:
 * Input: s = "ubv?w"
 * Output: "ubvaw"
 * Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings
 * will consist of consecutive repeating characters in "ubvvw" and "ubvww".
 *
 * Constraints:
 *     1 <= s.length <= 100
 *     s consist of lowercase English letters and '?'.
 * </pre>
 *
 * @see <a href="https://youtu.be/OgMnvWfhqrk">Video solution</a>
 */
public class ReplaceQCharToAvoidConsecutiveRepeatingChars {

    private final static Set<Character> CHARS = Set.of('x', 'y', 'z');

    public String modifyString(String s) {
        if (StringUtils.isEmpty(s)) {
            return s;
        }

        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = selectChar(chars, i);
            }
        }
        return new String(chars);
    }

    private char selectChar(char[] chars, int pos) {
        var set = new HashSet<>(CHARS);
        if (pos > 0) {
            set.remove(chars[pos - 1]);
        }
        if (pos < chars.length - 1) {
            set.remove(chars[pos + 1]);
        }
        return set.iterator().next();
    }
}
