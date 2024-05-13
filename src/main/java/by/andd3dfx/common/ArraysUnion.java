package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Даны 2 упорядоченных массива с уникальными элементами,
 * найти и вывести их упорядоченное объединение без дубликатов.
 *
 * @see <a href="https://youtu.be/uABGnnTD0Kw">Video solution</a>
 */
public class ArraysUnion {

    public static int[] unite(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();

        int aIndex = 0;
        int bIndex = 0;
        Integer lastAdded = null;

        // Process overlapping part of arrays
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                var itemToAdd = a[aIndex];
                lastAdded = addItemToArray(result, itemToAdd, lastAdded);
                aIndex++;
            } else {
                var itemToAdd = b[bIndex];
                lastAdded = addItemToArray(result, itemToAdd, lastAdded);
                bIndex++;
            }
        }

        // Add the remaining part of one of the arrays
        Arrays.stream(Arrays.copyOfRange(a, aIndex, a.length))
                .forEach(result::add);
        Arrays.stream(Arrays.copyOfRange(b, bIndex, b.length))
                .forEach(result::add);

        return result.stream()
                .mapToInt(value -> value)
                .toArray();
    }

    private static Integer addItemToArray(List<Integer> array, int itemToAdd, Integer lastAdded) {
        if (lastAdded == null || itemToAdd != lastAdded) {
            array.add(itemToAdd);
            lastAdded = itemToAdd;
        }
        return lastAdded;
    }

    public static int[] uniteUsingSet(int[] a, int[] b) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        int aIndex = 0;
        int bIndex = 0;

        // Process overlapping part of arrays
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                result.add(a[aIndex]);
                aIndex++;
            } else {
                result.add(b[bIndex]);
                bIndex++;
            }
        }

        // Add the remaining part of one of the arrays
        Arrays.stream(Arrays.copyOfRange(a, aIndex, a.length))
                .forEach(result::add);
        Arrays.stream(Arrays.copyOfRange(b, bIndex, b.length))
                .forEach(result::add);

        return result.stream()
                .mapToInt(value -> value)
                .toArray();
    }
}
