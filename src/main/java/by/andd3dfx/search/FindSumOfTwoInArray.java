package by.andd3dfx.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find in array of integers two items which have sum equals to definite number. Try to solve task using algorithm with
 * O(n) complexity.
 */
public class FindSumOfTwoInArray {

    public static int[] find(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            final int item = arr[i];
            if (set.contains(sum - item)) {
                return new int[]{valueToIndexMap.get(sum - item), i};
            }

            set.add(item);
            valueToIndexMap.put(item, i);
        }
        return null;
    }
}
