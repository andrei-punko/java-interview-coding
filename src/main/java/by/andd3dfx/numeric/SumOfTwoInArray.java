package by.andd3dfx.numeric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function that, given a list and a target sum, returns zero-based indices of any two distinct elements whose
 * sum is equal to the target sum. If there are no such elements, the function should return null.
 * <p>
 * For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12) should return a single dimensional array with two elements
 * and contain any of the following pairs of indices:
 * <pre>
 *     1 and 4 (3 + 9 = 12)
 *     2 and 3 (5 + 7 = 12)
 *     3 and 2 (7 + 5 = 12)
 *     4 and 1 (9 + 3 = 12)
 * </pre>
 */
public class SumOfTwoInArray {

    public static int[] find_N2(int[] array, int sum) {
        for (var i = 0; i < array.length - 1; i++) {
            for (var j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] find_2N(int[] list, int sum) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int index = 0; index < list.length; index++) {
            int key = list[index];
            List<Integer> indexes = map.get(key);
            if (indexes == null) {
                indexes = new ArrayList<>();
                map.put(key, indexes);
            }
            indexes.add(index);
        }

        for (Integer key : map.keySet()) {
            int remainderToFind = sum - key;
            if (map.containsKey(remainderToFind)) {
                if (remainderToFind == key) {
                    if (map.get(key).size() < 2) {
                        continue;
                    }
                    return new int[]{map.get(key).get(0), map.get(key).get(1)};
                }
                return new int[]{map.get(key).get(0), map.get(remainderToFind).get(0)};
            }
        }

        return null;
    }
}
