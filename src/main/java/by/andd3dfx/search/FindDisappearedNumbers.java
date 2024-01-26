package by.andd3dfx.search;

import java.util.Arrays;

/**
 * <pre>
 * Дан неупорядоченный массив из N чисел от 1 до N,
 * при этом несколько чисел из диапазона [1, N] пропущено, а некоторые присутствуют дважды.
 * Найти все пропущенные числа без использования дополнительной памяти.
 * </pre>
 */
public class FindDisappearedNumbers {

    /**
     * <pre>
     * Use item sign to store an info is this number happens before or not:
     *  input: [1 3 3]
     *  [-1 3 3]
     *  [-1 3 -3]
     *  [-1 3 -3]
     * ---
     * output: [2]
     *
     * input: [3 3 3]
     * ...
     * [3 3 -3]
     * ---
     * output: [1 2]
     *
     * input: [3 1 2]
     * ...
     * [-3 -1 -2]
     * ---
     * output: []
     * </pre>
     */
    public static int[] find(int[] items) {
        for (int i = 0; i < items.length; i++) {
            var index = Math.abs(items[i]) - 1;
            if (items[index] > 0) {
                items[index] = -items[index];
            }
        }
        System.out.println(Arrays.toString(items));

        var amount = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] > 0) {
                items[amount] = i + 1;
                amount++;
            }
        }
        return Arrays.copyOfRange(items, 0, amount);
    }
}
