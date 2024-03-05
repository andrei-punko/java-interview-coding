package by.andd3dfx.common;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 * Дано К массивов целых чисел длиной N каждый, упорядоченных по возрастанию.
 * Вернуть один массив, содержащий все эти числа, также упорядоченные по возрастанию.
 *
 * Пример:
 * [[1,2,3], [4,6,7], [2,5,9]] -> [1,2,2,3,4,5,6,7,9]
 *
 * Оценить сложность алгоритма; желательно получить его лучше, чем O(KN*log(KN)).
 * </pre>
 */
public class MergeArrays {

    /**
     * Судя по всему сложность получается KN*log(K)
     */
    public static int[] merge(int[][] arrays) {
        var k = arrays.length;
        if (k == 0) {
            return new int[]{};
        }
        var n = arrays[0].length;
        if (n == 0) {
            return new int[]{};
        }

        int[] result = new int[k * n];
        int[] marker = new int[k];
        int globalIndex = 0;

        PriorityQueue<Item> queue = new PriorityQueue<>(Comparator.comparingInt(item -> item.value));
        for (int i = 0; i < k; i++) {
            queue.add(new Item(arrays[i][0], i));
        }

        while (globalIndex < k * n) {
            Item item = queue.poll();
            result[globalIndex] = item.value;
            globalIndex++;

            marker[item.arrayIndex]++;
            if (marker[item.arrayIndex] < n) {
                queue.add(new Item(arrays[item.arrayIndex][marker[item.arrayIndex]], item.arrayIndex));
            }
        }
        return result;
    }

    @AllArgsConstructor
    public static class Item {
        private int value;
        private int arrayIndex;
    }
}
