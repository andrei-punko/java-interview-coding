package by.andd3dfx.interview.goldmansachs;

import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 * Write a function that transforms string into a new string. New string does not contain repeating letters
 * but contains a number after every letter that means how many times the letter was repeated in the original string.
 * a.	“” -> “”
 * b.	“a” -> “a1”
 * c.	“aaa” -> “a3”
 * d.	“aaabbc” -> “a3b2c1”
 * </pre>
 */
public class LettersFrequencies {

    public static String build(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        String result = "";
        for (Character key : map.keySet()) {
            result += String.format("%s%d", key, map.get(key));
        }
        return result;
    }
}
