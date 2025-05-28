package by.andd3dfx.sorting;

/**
 * @see <a href="https://youtu.be/sQLeZOOmxlo">Video solution</a>
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void apply(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (lessThan(array[j], array[minIndex])) minIndex = j;
            }

            swap(array, i, minIndex);
        }
    }

    private static <T extends Comparable<T>> boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private static <T> void swap(T[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
