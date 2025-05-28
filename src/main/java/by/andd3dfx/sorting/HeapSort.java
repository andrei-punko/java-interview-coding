package by.andd3dfx.sorting;

public class HeapSort {

    public static <T extends Comparable<T>> void apply(T[] items) {
        var n = items.length;

        // Build heap (rearrange array)
        for (var i = n / 2 - 1; i >= 0; i--) {
            heapify(items, n, i);
        }

        // One by one extract an element from heap
        for (var i = n - 1; i > 0; i--) {
            // Move current root to the end
            swap(items, 0, i);

            // Call max heapify on the reduced heap
            heapify(items, i, 0);
        }
    }

    // Heapify a subtree rooted with node items[root].
    // n is size of heap
    private static <T extends Comparable<T>> void heapify(T[] items, int n, int root) {
        var largest = root;
        var l = 2 * root + 1;
        var r = l + 1;

        // If left child is larger than root
        if (l < n && greaterThan(items[l], items[largest])) {
            largest = l;
        }

        // If right child is larger than largest at this moment
        if (r < n && greaterThan(items[r], items[largest])) {
            largest = r;
        }

        // If largest is not root
        if (largest != root) {
            swap(items, root, largest);

            // Recursively heapify the affected subtree
            heapify(items, n, largest);
        }
    }

    private static <T extends Comparable<T>> boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    private static <T> void swap(T[] items, int i, int j) {
        var tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
