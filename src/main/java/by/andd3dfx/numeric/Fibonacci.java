package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

/**
 * Check <a href="https://habr.com/ru/post/423939/">this article</a>
 * for comparison of top-down / down-top approaches:
 *
 * @see <a href="https://youtu.be/S5rfbd8JkWw">Video solution</a>
 */
public class Fibonacci {

    private static final Map<Integer, Integer> map = new HashMap<>() {{
        put(0, 0);
        put(1, 1);
    }};

    /**
     * Top-down approach (recursive, better)
     */
    public static int calculateTopDown(int n) {
        if (n < 0) throw new IllegalArgumentException("Number should be not less than 0!");

        if (!map.containsKey(n)) {
            map.put(n, calculateTopDown(n - 1) + calculateTopDown(n - 2));
        }

        return map.get(n);
    }

    /**
     * Down-top approach (loop, just as example)
     */
    public static int calculateDownTop(int n) {
        if (n < 0) throw new IllegalArgumentException("Number should be not less than 0!");

        for (int i = 2; i <= n; i++) {
            map.put(n, map.get(n - 1) + map.get(n - 2));
        }
        return map.get(n);
    }
}
