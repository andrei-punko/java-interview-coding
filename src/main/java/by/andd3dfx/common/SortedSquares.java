package by.andd3dfx.common;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Дан массив целых чисел, отсортированный по возрастанию.
 * Вернуть массив, содержащий эл-ты исходного массива в квадрате, также отсортированный по возрастанию.
 * <p>
 * Пример:
 * [-5,-3,0,1,2,4] -> [0,1,4,9,16,25]
 */
public class SortedSquares {

    public static Integer[] transform(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(value -> value * value)
                .sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }
}
