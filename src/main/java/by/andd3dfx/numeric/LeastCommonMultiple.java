package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

/**
 * See <a href="https://en.wikipedia.org/wiki/Least_common_multiple">article</a> in wiki
 * <p>
 * Find the least common multiple of numbers array
 */
public class LeastCommonMultiple {

    public static int find(int[] numbers) {
        Map<Integer, Integer> dividerNItsPowerMap = new HashMap<>();
        for (int number : numbers) {
            determineDividersAndTheirMaxPower(number, dividerNItsPowerMap);
        }

        var result = 1;
        for (var entry : dividerNItsPowerMap.entrySet()) {
            result *= (int) Math.pow(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private static void determineDividersAndTheirMaxPower(int number, Map<Integer, Integer> dividerAndItsPower) {
        while (number > 1) {
            for (var divider = 2; divider <= number; divider++) {
                var power = 0;
                while (number % divider == 0) {
                    number /= divider;
                    power++;
                }

                if (power > 0) {
                    if (!dividerAndItsPower.containsKey(divider) || power > dividerAndItsPower.get(divider)) {
                        dividerAndItsPower.put(divider, power);
                    }
                }
            }
        }
    }
}
