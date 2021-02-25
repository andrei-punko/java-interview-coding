package by.andd3dfx.sorting;

public class MergeSort extends AbstractSort {

    @Override
    public void sort() {
        mergeSort(items);
    }

    public void mergeSort(Long[] items) {
        int n = items.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Long[] left = new Long[mid];
        Long[] right = new Long[n - mid];

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

    public void merge(Long[] items, Long[] left, Long[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
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
