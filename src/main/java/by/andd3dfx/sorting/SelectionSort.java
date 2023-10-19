package by.andd3dfx.sorting;

public class SelectionSort {

    public static <T extends Comparable> void apply(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min_index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (lessThan(array[j], array[min_index])) min_index = j;
            }

            swap(array, i, min_index);
        }
    }

    private static <T extends Comparable> boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private static <T> void swap(T[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
