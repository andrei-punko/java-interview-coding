package by.andd3dfx.common;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Дано К массивов целых чисел длиной N каждый, упорядоченных по возрастанию.
 * Вернуть один массив, содержащий все эти числа, также упорядоченные по возрастанию.
 * Пример:
 * [[1,2,3], [4,6,7], [2,5,9]] -> [1,2,2,3,4,5,6,7,9]
 * <p>
 * Оценить сложность алгоритма (желательно получить сложность лучше, чем KN*log(KN)).
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
        int[] marker = new int[3];
        int globalIndex = 0;

        PriorityQueue<Item> queue = new PriorityQueue<>(Comparator.comparingInt(item -> item.value));
        queue.add(new Item(arrays[0][0], 0));
        queue.add(new Item(arrays[1][0], 1));
        queue.add(new Item(arrays[2][0], 2));

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
        int value;
        int arrayIndex;
    }
}
