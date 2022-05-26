package by.andd3dfx.common;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * Constraints:
 * 1 <= n <= 8
 * <p>
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static List<String> generate(int n) {
        if (n == 1) {
            return List.of("()");
        }

        List<String> strings = generate(n - 1);
        Set<String> result = new HashSet<>();
        for (String string : strings) {
            result.add("(" + string + ")"); // Wrap with "()"
            result.add("()" + string);      // Add "()" at the left
            result.add(string + "()");      // Add "()" at the right
        }
        return result.stream().collect(Collectors.toList());
    }
}
