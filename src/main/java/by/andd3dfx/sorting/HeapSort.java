package by.andd3dfx.sorting;

public class HeapSort {

    public static <T extends Comparable> void apply(T[] items) {
        int n = items.length;

        // Build heap (rearrange array)
        for (var i = n / 2 - 1; i >= 0; i--) {
            heapify(items, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            swap(items, 0, i);

            // Call max heapify on the reduced heap
            heapify(items, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[].
    // n is size of heap
    private static <T extends Comparable> void heapify(T arr[], int n, int i) {
        int largest = i;    // Initialize largest element as root
        int l = 2 * i + 1;
        int r = l + 1;

        // If left child is larger than root
        if (l < n && greaterThan(arr[l], arr[largest])) {
            largest = l;
        }

        // If right child is larger than largest at this moment
        if (r < n && greaterThan(arr[r], arr[largest])) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    private static <T extends Comparable> boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    private static <T> void swap(T[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
