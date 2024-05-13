package by.andd3dfx.sorting;

import java.util.Arrays;

/**
 * @see <a href="https://youtu.be/QsXDi0MABA0">Video solution</a>
 */
public class MergeSort {

    public static <T extends Comparable> void apply(T[] items) {
        int n = items.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;

        var left = Arrays.copyOfRange(items, 0, mid);
        var right = Arrays.copyOfRange(items, mid, n);

        apply(left);
        apply(right);

        merge(items, left, right);
    }

    private static <T extends Comparable> void merge(T[] items, T[] left, T[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (lessOrEqualsThan(left[i], right[j])) {
                items[k] = left[i];
                k++;
                i++;
            } else {
                items[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < leftLength) {
            items[k] = left[i];
            k++;
            i++;
        }
        while (j < rightLength) {
            items[k] = right[j];
            k++;
            j++;
        }
    }

    private static <T extends Comparable> boolean lessOrEqualsThan(T a, T b) {
        return a.compareTo(b) <= 0;
    }
}
