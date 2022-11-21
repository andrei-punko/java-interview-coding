package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

    private final static Map<Integer, Integer> cache = new HashMap<>() {{
        put(0, 1);
    }};

    /**
     * Down-top approach
     */
    public static int loop(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be >= 0");
        }

        if (n == 0) {
            return 1;
        }

        var result = 1;
        for (var i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Top-down approach
     */
    public static int recursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be >= 0");
        }

        if (n == 0) {
            return 1;
        }

        return n * recursion(n - 1);
    }

    /**
     * Top-down approach
     */
    public static int recursionWithCache(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be >= 0");
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = n * recursionWithCache(n - 1);
        cache.put(n, result);
        return result;
    }

    /**
     * Down-top approach
     */
    public static int loopWithCache(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be >= 0");
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        for (var i = 1; i <= n; i++) {
            cache.put(i, i * cache.get(i - 1));
        }
        return cache.get(n);
    }
}
