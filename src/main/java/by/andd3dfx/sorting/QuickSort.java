package by.andd3dfx.sorting;

public class QuickSort extends AbstractSort {

    @Override
    public void sort() {
        quickSort(items, 0, items.length - 1);
    }

    private void quickSort(Long[] items, int low, int high) {
        if (low < high) {
            int p = partition(items, low, high);
            quickSort(items, low, p);
            quickSort(items, p + 1, high);
        }
    }

    private int partition(Long[] items, int low, int high) {
        Long v = items[(low + high) / 2];
        int i = low;
        int j = high;

        while (i <= j) {
            while (items[i] < v) {
                i++;
            }
            while (items[j] > v) {
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
