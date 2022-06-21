package by.andd3dfx.sorting.others;

import java.util.LinkedHashMap;

/**
 * We have very long array of people ages.
 * Need to print amount of people for each age.
 */
public class ArrayOfAges {

    /**
     * We use "bucket sorting" approach to collect statistics,
     * because ages belongs to definite range [0-130].
     * <p>
     * In result we got O(1) consumption of additional memory.
     */
    public static LinkedHashMap<Integer, Long> process(int[] ages) {
        long[] buckets = new long[130];
        for (int age : ages) {
            buckets[age]++;
        }

        LinkedHashMap<Integer, Long> map = new LinkedHashMap<>();
        for (int age = 0; age < buckets.length; age++) {
            if (buckets[age] > 0) {
                map.put(age, buckets[age]);
            }
        }
        return map;
    }
}
