package by.andd3dfx.search;

import java.util.Arrays;

/**
 * <pre>
 * Есть массив целых чисел А. Необходимо для каждого элемента вывести размер его окрестности.
 * Окрестностью является непрерывная последовательность чисел той же четности, в которую входит рассматриваемое число.
 *
 * Пример: для массива [1, 2, 4, 6, 1, 3, 2] результат будет [1, 3, 3, 3, 2, 2, 1]
 * </pre>
 */
public class FindNeighborhoodSequence {

    public static int[] find(int[] items) {
        int[] result = new int[items.length];

        int curr = 0;
        while (curr < items.length) {
            int shift = 1;
            while (curr + shift < items.length && (items[curr] - items[curr + shift]) % 2 == 0) {
                shift++;
            }

            Arrays.fill(result, curr, curr + shift, shift);
            curr += shift;
        }

        return result;
    }
}
