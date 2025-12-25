package by.andd3dfx.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/valid-anagram/">Task description</a>
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *     1 <= s.length, t.length <= 5 * 104
 *     s and t consist of lowercase English letters.
 * </pre>
 *
 * @see <a href="https://youtu.be/8doD_ZqlHL0">Video solution</a>
 */
public class ValidAnagram {

    public static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (var ch : s1.toCharArray()) {
            if (!frequencies.containsKey(ch)) {
                frequencies.put(ch, 0);
            }
            frequencies.put(ch, frequencies.get(ch) + 1);
        }

        for (var ch : s2.toCharArray()) {
            if (!frequencies.containsKey(ch) || frequencies.get(ch) == 0) {
                return false;
            }
            frequencies.put(ch, frequencies.get(ch) - 1);
        }
        return frequencies.values().stream()
            .filter(value -> value > 0).findAny().isEmpty();
    }

    public static boolean isAnagram2(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
