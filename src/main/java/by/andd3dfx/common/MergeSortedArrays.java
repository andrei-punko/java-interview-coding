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
public class MergeSortedArrays {

    /**
     * Судя по всему сложность получается KN*log(K)
     */
    public static int[] merge(int[][] arrays) {
        final int K = arrays.length;
        if (K == 0) {
            return new int[]{};
        }
        final int N = arrays[0].length;
        if (N == 0) {
            return new int[]{};
        }

        var queue = new PriorityQueue<Item>(Comparator.comparingInt(item -> item.value));
        for (int i = 0; i < K; i++) {
            var value = arrays[i][0];
            queue.add(new Item(value, i));
        }

        int[] result = new int[K * N];
        int[] markers = new int[K];
        int globalIndex = 0;

        while (globalIndex < K * N) {
            Item item = queue.poll();
            result[globalIndex] = item.value;
            globalIndex++;

            var i = item.index;
            markers[i]++;
            if (markers[i] < N) {
                var value = arrays[i][markers[i]];
                queue.add(new Item(value, i));
            }
        }
        return result;
    }

    @AllArgsConstructor
    public static class Item {
        private int value;
        private int index;
    }
}
