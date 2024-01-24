package by.andd3dfx.search;

import java.util.Arrays;

/**
 * Дан неупорядоченный массив из N чисел от 1 до N,
 * при этом несколько чисел из диапазона [1, N] пропущено, а некоторые присутствуют дважды.
 * Найти все пропущенные числа без использования дополнительной памяти.
 */
public class FindDisappearedNumbers {

    public static int[] find(int[] items) {
        for (int i = 0; i < items.length; i++) {
            var index = Math.abs(items[i]) - 1;
            if (items[index] > 0) {
                items[index] = -items[index];
            }
        }

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
