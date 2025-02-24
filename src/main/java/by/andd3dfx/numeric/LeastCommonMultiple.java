package by.andd3dfx.numeric;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Find the least common multiple of numbers array
 *
 * Determination of least common multiple: <a href="https://en.wikipedia.org/wiki/Least_common_multiple">article in wiki</a>
 * </pre>
 *
 * @see <a href="https://youtu.be/jR0Ei_3O7EM">Video solution</a>
 */
public class LeastCommonMultiple {

    /**
     * НОК(4, 6) - ?
     * 4 8 12 16 ...
     * 6 12 18 24 ...
     * НОК(4, 6) = 12
     * <p>
     * 4 = 2^2
     * 6 = 2 * 3
     * НОК(4, 6) = 2^2 * 3 = 12
     */
    public static int find(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array should be populated!");
        }

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

    private static void determineDividersAndTheirMaxPower(int number, Map<Integer, Integer> dividerNItsPowerMap) {
        while (number > 1) {
            for (var divider = 2; divider <= number; divider++) {
                var power = 0;
                while (number % divider == 0) {
                    power++;
                    number /= divider;
                }

                if (power > 0) {
                    if (!dividerNItsPowerMap.containsKey(divider)
                            || power > dividerNItsPowerMap.get(divider)) {
                        dividerNItsPowerMap.put(divider, power);
                    }
                }
            }
        }
    }

    /**
     * НОК(a,b) = (a*b) / НОД(a,b)
     */
    public static int find_usingGCD(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array should be populated!");
        }

        var result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = findForPair(result, numbers[i]);
        }
        return result;
    }

    private static int findForPair(int a, int b) {
        return (a * b) / GreatestCommonDivisor.determineUsingLoop(a, b);
    }
}
