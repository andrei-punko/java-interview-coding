package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Map<Integer, Long> map = new HashMap<Integer, Long>() {{
        put(1, 1L);
        put(2, 1L);
    }};

    public static long get(int n) {
        if (n < 1) throw new IllegalArgumentException("Number should be greater than 0!");

        if (!map.containsKey(n)) {
            map.put(n, get(n - 1) + get(n - 2));
        }

        return map.get(n);
    }
}
