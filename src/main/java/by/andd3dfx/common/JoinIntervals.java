package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Дан упорядоченный массив натуральных чисел,
 * повторяющихся элементов в списке нет.
 * Нужно преобразовать в строку с перечислением интервалов через запятую.
 *
 * Пример:
 * [2, 3, 5, 6, 7, 8, 11, 20, 21, 22] -> "2-3,5-8,11,20-22"
 * </pre>
 */
public class JoinIntervals {

    public static String transform(int[] a) {
        if (a.length == 0) {
            return "";
        }

        List<String> items = new ArrayList<>();
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

        return String.join(",", items);
    }
}
