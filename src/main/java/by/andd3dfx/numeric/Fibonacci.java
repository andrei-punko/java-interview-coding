package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

/**
 * Check this article for comparison of top-down / down-top approaches:
 * https://habr.com/ru/post/423939/
 */
public class Fibonacci {

    private static final Map<Integer, Long> map = new HashMap<>() {{
        put(0, 0L);
        put(1, 1L);
    }};

    /**
     * Top-down approach (recursive, better)
     */
    public static long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Number should be not less than 0!");

        if (!map.containsKey(n)) {
            map.put(n, calculate(n - 1) + calculate(n - 2));
        }

        return map.get(n);
    }

    /**
     * Down-top approach (just as example)
     */
    public static long calculate2(int n) {
        if (n < 0) throw new IllegalArgumentException("Number should be not less than 0!");

        for (int i = 2; i <= n; i++) {
            map.put(n, map.get(n - 1) + map.get(n - 2));
        }
        return map.get(n);
    }
}
