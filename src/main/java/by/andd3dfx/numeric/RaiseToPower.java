package by.andd3dfx.numeric;

import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * <pre>
 * https://leetcode.com/problems/powx-n/
 *
 * Raise number a to power p
 *
 * Based on "Stephens - Essential Algorithms"
 * </pre>
 */
public class RaiseToPower {

    public static float apply(float a, int p) {
        boolean reversePowerFlag = (p < 0);
        if (reversePowerFlag) {
            p = -p;
        }

        float result = 1;
        for (int i = 0; i < p; i++) {
            result *= a;
        }

        if (reversePowerFlag) {
            return 1 / result;
        }
        return result;
    }

    public static float applyEnhanced(float a, int p) {
        boolean reversePowerFlag = (p < 0);
        if (reversePowerFlag) {
            p = -p;
        }

        // Calculate a, a^2, a^4 , a^8 etc, until we get a^N, where N + 1 > p
        TreeMap<Integer, Float> map = new TreeMap<>();
        map.put(1, a);
        for (int power = 1; 2 * power < p; power *= 2) {
            map.put(2 * power, map.get(power) * map.get(power));
        }

        // Use {a, a^2, ...} to calculate a^P
        NavigableSet<Integer> descendingKeySet = map.descendingKeySet();
        float result = 1;
        for (Integer power : descendingKeySet) {
            while (p >= power) {
                result *= map.get(power);
                p -= power;
                // System.out.println(power);
            }
        }

        if (reversePowerFlag) {
            return 1 / result;
        }
        return result;
    }
}
