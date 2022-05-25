package by.andd3dfx.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find in array of integers two items which have sum equals to definite number. Try to solve task using algorithm with
 * O(n) complexity.
 * <p>
 * Есть массив целых чисел и число K.
 * Найти два таких (не обязательно различных) числа в массиве, сумма которых равна K, либо вывести, что такого нет.
 */
public class FindSumOfTwoInArray {

    /**
     * O(n) complexity solution
     */
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

    /**
     * O(n^2) complexity solution
     */
    public static int[] find2(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            var item = arr[i];
            var needToFind = sum - item;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == needToFind) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
