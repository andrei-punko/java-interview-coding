package by.andd3dfx.sorting;

import java.util.Arrays;

/**
 * Find top k numbers in array
 *
 * @see <a href="https://youtu.be/iBOodbu0wKQ">Video solution</a>
 */
public class FindTopKNumbers {

    /**
     * We use short version of selection sort algorithm with O(kn) complexity
     */
    public static int[] find(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            int maxElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxElementIndex]) {
                    maxElementIndex = j;
                }
            }
            swap(array, i, maxElementIndex);
        }
        return Arrays.copyOf(array, k);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
