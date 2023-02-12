package by.andd3dfx.sorting;

import java.lang.reflect.Array;

public class MergeSort {

    public static <T extends Comparable> void apply(T[] items) {
        int n = items.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;

        T[] left = (T[]) Array.newInstance(Comparable.class, mid);
        T[] right = (T[]) Array.newInstance(Comparable.class, n - mid);

        for (int i = 0; i < mid; i++) {
            left[i] = items[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = items[i];
        }
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
