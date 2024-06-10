package by.andd3dfx.sorting;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * We have a very long array of people ages.
 * Need to count number of people for each age.
 */
public class ArrayOfAges {

    /**
     * We use the "bucket sorting" approach to collect statistics,
     * because ages belong to definite range [0-130].
     * <p>
     * In result, we got O(1) consumption of additional memory.
     */
    public static Map<Integer, Long> process(int[] ages) {
        long[] buckets = new long[130];
        for (var age : ages) {
            buckets[age]++;
        }

        Map<Integer, Long> map = new LinkedHashMap<>();
        for (var age = 0; age < buckets.length; age++) {
            if (buckets[age] > 0) {
                map.put(age, buckets[age]);
            }
        }
        return map;
    }
}
