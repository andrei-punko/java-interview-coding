package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Home version
     */
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

    /**
     * Interview version
     */
    public static String transform2(int[] nums) {
        var result = new ArrayList<String>();
        var len = nums.length;
        int leftBorderIndex = 0;
        boolean intervalDetected = false;

        int i = 0;
        for (; i < len - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                if (!intervalDetected) {
                    leftBorderIndex = i;
                    intervalDetected = true;
                }
            } else {
                if (intervalDetected) {
                    result.add(nums[leftBorderIndex] + "-" + nums[i]);
                    intervalDetected = false;
                } else {
                    result.add(String.valueOf(nums[i]));
                }
            }
        }

        if (intervalDetected) {
            result.add(nums[leftBorderIndex] + "-" + nums[i]);
        } else {
            result.add(String.valueOf(nums[i]));
        }

        return result.stream().collect(Collectors.joining(","));
    }
}
