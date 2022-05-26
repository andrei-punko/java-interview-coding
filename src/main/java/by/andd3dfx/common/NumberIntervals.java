package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Дан упорядоченный массив натуральных чисел,
 * повторяющихся элементов в списке нет.
 * Нужно преобразовать в строку с перечислением интервалов через запятую.
 * <p>
 * Пример:
 * [2, 3, 5, 6, 7, 8, 11, 20, 21, 22] -> "2-3,5-8,11,20-22"
 */
public class NumberIntervals {

    public static String transform(int[] a) {
        List<String> items = new ArrayList<>();
        if (a.length == 0) {
            return "";
        }

        int lastItem = a[0];
        int startIntervalValue = a[0];
        boolean intervalDetected = false;
        int index = 1;

        while (index < a.length) {
            var currItem = a[index];
            if (currItem == lastItem + 1) {
                if (!intervalDetected) {
                    startIntervalValue = lastItem;
                    intervalDetected = true;
                }
            } else {
                if (intervalDetected) {
                    items.add(startIntervalValue + "-" + lastItem);
                    intervalDetected = false;
                } else {
                    items.add(String.valueOf(lastItem));
                }
            }
            lastItem = currItem;
            index++;
        }

        if (intervalDetected) {
            items.add(startIntervalValue + "-" + lastItem);
        } else {
            items.add(String.valueOf(lastItem));
        }

        return items.stream().collect(Collectors.joining(","));
    }
}
