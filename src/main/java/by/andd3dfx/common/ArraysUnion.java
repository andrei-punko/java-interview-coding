package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Даны 2 упорядоченных (отсортированных) массива с уникальными элементами,
 * найти и вывести их упорядоченное объединение без дубликатов.
 */
public class ArraysUnion {

    /**
     * Using Streams
     */
    public static Integer[] unite(int[] a, int[] b) {
        return Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .collect(Collectors.toSet())
                .stream().sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }

    /**
     * Using manual iteration through arrays
     */
    public static Integer[] unite2(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();

        int aIndex = 0;
        int bIndex = 0;
        Integer lastAdded = null;

        // Process overlapping part of arrays
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                var itemToAdd = a[aIndex];
                if (lastAdded == null || itemToAdd != lastAdded) {
                    result.add(itemToAdd);
                    lastAdded = itemToAdd;
                }
                aIndex++;
            } else {
                var itemToAdd = b[bIndex];
                if (lastAdded == null || itemToAdd != lastAdded) {
                    result.add(itemToAdd);
                    lastAdded = itemToAdd;
                }
                bIndex++;
            }
        }

        // Add remaining part of one of arrays
        if (aIndex < a.length) {
            for (int i = aIndex; i < a.length; i++) {
                result.add(a[i]);
            }
        }
        if (bIndex < b.length) {
            for (int i = bIndex; i < b.length; i++) {
                result.add(b[i]);
            }
        }

        return result.toArray(new Integer[0]);
    }
}
