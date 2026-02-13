package by.andd3dfx.string;

import java.util.LinkedHashMap;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/description/">Task description</a>
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation: The character 'l' at index 0 is the first character that does not occur at any other index.
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * </pre>
 */
public class FirstUniqueCharacterInString {

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (var ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
