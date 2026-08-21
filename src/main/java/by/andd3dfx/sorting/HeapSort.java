package by.andd3dfx.sorting;

/**
 * <pre>
 * Heap Sort (Piramidal sort)
 * Time Complexity: O(n log n) - Average, Worst, and Best case
 * Space Complexity: O(1) - In-place sorting
 * Stability: Unstable
 * </pre>
 */
public class HeapSort {

    public static <T extends Comparable<T>> void apply(T[] items) {
        if (items == null || items.length <= 1) {
            return; // No sorting needed for null or single element arrays
        }

        var n = items.length;

        // --- Phase 1: Build Max-Heap ---
        // Start from the last non-leaf node and move up to the root.
        // Formula for last non-leaf node index: (n / 2) - 1
        for (var i = n / 2 - 1; i >= 0; i--) {
            heapify(items, n, i);
        }

        // --- Phase 2: Extract Elements from Heap ---
        // Move the root (maximum element) to the end and reduce heap size
        for (var i = n - 1; i > 0; i--) {
            // Move current root to the end of array
            swap(items, 0, i);

            // Call max_heapify on remaining elements to restore heap property
            heapify(items, i, 0);
        }
    }

    /**
     * Helper method to maintain the Max-Heap property.
     * It compares the parent node with its children and ensures
     * that the largest element is at the root position of the subtree.
     *
     * @param arr The array representing the heap
     * @param n   The size of the current heap (active portion of array)
     * @param i   The index of the parent node to sift down
     */
    private static <T extends Comparable<T>> void heapify(T[] items, int n, int root) {
        var largest = root;        // Assume parent is largest by default
        var left = 2 * root + 1;   // Calculate index of left child
        var right = 2 * root + 2;  // Calculate index of right child

        // If Left Child Exists and is larger than current largest
        if (left < n && greaterThan(items[left], items[largest])) {
            largest = left;
        }

        // If right child is larger than largest at this moment
        if (right < n && greaterThan(items[right], items[largest])) {
            largest = right;
        }

        // If the largest element is not the parent, swap and sift down
        if (largest != root) {
            swap(items, root, largest);
            heapify(items, n, largest);     // Recursively heapify the affected subtree
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
