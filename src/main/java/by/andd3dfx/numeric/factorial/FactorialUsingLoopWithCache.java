package by.andd3dfx.numeric.factorial;

import java.util.HashMap;
import java.util.Map;

/**
 * Down-top approach
 *
 * @see <a href="https://youtu.be/HZrTppQjXVs">Video solution</a>
 */
public class FactorialUsingLoopWithCache implements IFactorial {

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

        for (var i = 1; i <= n; i++) {
            cache.put(i, i * cache.get(i - 1));
        }
        return cache.get(n);
    }
}
