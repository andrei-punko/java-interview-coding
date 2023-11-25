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

    public static Integer[] uniteUsingStreams(int[] a, int[] b) {
        return Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .collect(Collectors.toSet())
                .stream().sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }

    public static Integer[] uniteUsingManualIteration(int[] a, int[] b) {
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

        // Add the remaining part of one of the arrays
        Arrays.stream(Arrays.copyOfRange(a, aIndex, a.length))
                .forEach(result::add);
        Arrays.stream(Arrays.copyOfRange(b, bIndex, b.length))
                .forEach(result::add);

        return result.toArray(new Integer[0]);
    }
}
