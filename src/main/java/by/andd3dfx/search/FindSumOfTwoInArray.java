package by.andd3dfx.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Find in array of integers two items which have sum equals to definite number.
 * Try to solve task using algorithm with O(n) complexity.
 * <p>
 * Есть массив целых чисел и число K.
 * Найти два таких (не обязательно различных) числа в массиве, сумма которых равна K, либо вывести, что такого нет.
 */
public class FindSumOfTwoInArray {

    public static int[] find_On2(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] find_On(int[] arr, int sum) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            var item = arr[i];
            if (valueToIndexMap.containsKey(sum - item)) {
                return new int[]{i, valueToIndexMap.get(sum - item)};
            }
            valueToIndexMap.put(item, i);
        }
        return null;
    }
}
