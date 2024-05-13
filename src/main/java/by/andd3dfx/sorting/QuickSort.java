package by.andd3dfx.sorting;

/**
 * @see <a href="https://youtu.be/lp1UsN1-_p4">Video solution</a>
 */
public class QuickSort {

    public static <T extends Comparable> void apply(T[] items) {
        quickSort(items, 0, items.length - 1);
    }

    private static <T extends Comparable> void quickSort(T[] items, int low, int high) {
        if (low < high) {
            int p = partition(items, low, high);
            quickSort(items, low, p);
            quickSort(items, p + 1, high);
        }
    }

    private static <T extends Comparable> int partition(T[] items, int low, int high) {
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
            swap(items, i, j);
            i++;
            j--;
        }

        return j;
    }

    private static <T extends Comparable> boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private static <T extends Comparable> boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    private static <T> void swap(T[] items, int i, int j) {
        var tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
