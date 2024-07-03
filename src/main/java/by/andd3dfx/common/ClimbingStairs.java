package by.andd3dfx.common;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">Task description</a>
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *   Input: n = 2
 *   Output: 2
 *   Explanation: There are two ways to climb to the top.
 *   1. 1 step + 1 step
 *   2. 2 steps
 *
 * Example 2:
 *   Input: n = 3
 *   Output: 3
 *   Explanation: There are three ways to climb to the top.
 *   1. 1 step + 1 step + 1 step
 *   2. 1 step + 2 steps
 *   3. 2 steps + 1 step
 *
 * Constraints:
 *   1 <= n <= 45
 * </pre>
 *
 * @see <a href="https://youtu.be/bjE3KQM4ko4">Video solution</a>
 */
public class ClimbingStairs {

    private static final Map<Integer, Integer> cache = new HashMap<>() {{
        put(0, 1);
        put(1, 1);
    }};

    public static int calc(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        var result = calc(n - 1) + calc(n - 2);
        cache.put(n, result);
        return result;
    }
}
