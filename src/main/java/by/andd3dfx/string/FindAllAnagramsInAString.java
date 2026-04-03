package by.andd3dfx.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Task description</a>
 *
 * Given two strings s and p, return an array of all the start indices of p's in s. You may return the answer in any order.
 *
 * Example 1:
 *   Input: s = "cbaebabacd", p = "abc"
 *   Output: [0,6]
 *   Explanation:
 *   The substring with start index = 0 is "cba", which is an anagram of "abc".
 *   The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *   Input: s = "abab", p = "ab"
 *   Output: [0,1,2]
 *   Explanation:
 *   The substring with start index = 0 is "ab", which is an anagram of "ab".
 *   The substring with start index = 1 is "ba", which is an anagram of "ab".
 *   The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 */
public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        var normalizedP = normalize(p);

        Set<String> approvedStrings = new HashSet<>();
        approvedStrings.add(normalizedP);
        for (var start = 0; start <= s.length() - p.length(); start++) {
            String candidate = s.substring(start, start + p.length());

            if (approvedStrings.contains(candidate) || normalizedP.equals(normalize(candidate))) {
                approvedStrings.add(candidate);
                result.add(start);
            }
        }

        return result;
    }

    private static String normalize(String p) {
        var chars = p.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
