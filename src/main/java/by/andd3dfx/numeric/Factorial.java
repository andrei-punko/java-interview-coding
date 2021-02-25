package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

    private static Map<Integer, Integer> cache = new HashMap<>();

    static {
        cache.put(0, 1);
    }

    public static int calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Wrong parameter");

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = n * calculate(n - 1);
        cache.put(n, result);
        return result;
    }
}
