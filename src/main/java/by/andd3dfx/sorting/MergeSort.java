package by.andd3dfx.sorting;

import java.lang.reflect.Array;

public class MergeSort extends AbstractSort {

    @Override
    public void sort() {
        mergeSort(items);
    }

    public <T extends Comparable> void mergeSort(T[] items) {
        int n = items.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;

        T[] left = (T[]) buildGenericArray(Comparable.class, mid);
        T[] right = (T[]) buildGenericArray(Comparable.class, n - mid);

        for (int i = 0; i < mid; i++) {
            left[i] = items[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = items[i];
        }
        mergeSort(left);
        mergeSort(right);

        merge(items, left, right);
    }

    public <E> E[] buildGenericArray(Class<E> clazz, int capacity) {
        return (E[]) Array.newInstance(clazz, capacity);
    }

    public <T extends Comparable> void merge(T[] items, T[] left, T[] right) {
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
}
