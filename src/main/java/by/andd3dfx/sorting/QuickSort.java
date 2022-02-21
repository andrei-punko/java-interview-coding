package by.andd3dfx.sorting;

public class QuickSort extends AbstractModernSort {

    @Override
    public void sort() {
        quickSort(items, 0, items.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] items, int low, int high) {
        if (low < high) {
            int p = partition(items, low, high);
            quickSort(items, low, p);
            quickSort(items, p + 1, high);
        }
    }

    private <T extends Comparable<T>> int partition(T[] items, int low, int high) {
        var v = items[(low + high) / 2];
        int i = low;
        int j = high;

        while (i <= j) {
            while (lessThan(items[i], v)) {
                i++;
            }
            while (greaterThan(items[j], v)) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
            i++;
            j--;
        }
        return j;
    }
}
