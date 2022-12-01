package by.andd3dfx.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 *
 * https://leetcode.com/problems/generate-parentheses/
 * <pre/>
 */
public class GenerateParentheses {

    public static List<String> generate(int n) {
        if (n == 1) {
            return List.of("()");
        }

        List<String> strings = generate(n - 1);
        Set<String> set = new HashSet<>();
        for (String string : strings) {
            set.add("(" + string + ")");    // Wrap with "()"
            set.add("()" + string);         // Add "()" at the left
            set.add(string + "()");         // Add "()" at the right
        }
        return set.stream().collect(Collectors.toList());
    }
}
