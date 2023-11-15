package by.andd3dfx.numeric.factorial;

import java.util.HashMap;
import java.util.Map;

/**
 * Top-down approach
 */
public class UsingRecursionWithCache implements IFactorial {

    private final static Map<Integer, Long> cache = new HashMap<>() {{
        put(0, 1L);
    }};

    @Override
    public long calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        var result = n * calc(n - 1);
        cache.put(n, result);
        return result;
    }
}
