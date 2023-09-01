package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * https://leetcode.com/problems/generate-parentheses/
 *
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
 * Example 3:
 * Input: n = 4
 * ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))",
 * "()(()())","()(())()","()()(())","()()()()"]
 *
 * Constraints:
 * 1 <= n <= 8
 * <pre/>
 */
public class GenerateParentheses {

    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, "", n, result);
        return result;
    }

    private static void generate(int opened, int closed, String current, int n, List<String> list) {
        if (opened + closed == 2 * n) {
            list.add(current);
            return;
        }

        if (opened < n) {
            generate(opened + 1, closed, current + "(", n, list);
        }

        if (opened > closed) {
            generate(opened, closed + 1, current + ")", n, list);
        }
    }
}
