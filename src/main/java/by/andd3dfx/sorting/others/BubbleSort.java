package by.andd3dfx.sorting.others;

public class BubbleSort {

    public static <T extends Comparable> void apply(T[] array) {
        var sorted = false;
        while (!sorted) {
            sorted = true;

            for (var i = 1; i < array.length; i++) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    swap(array, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public static <T extends Comparable> void apply2(T[] array) {
        for (var outIndex = array.length - 1; outIndex > 0; outIndex--) {
            for (var inIndex = 0; inIndex < outIndex; inIndex++) {
                if (array[inIndex].compareTo(array[inIndex + 1]) > 0) {
                    swap(array, inIndex, inIndex + 1);
                }
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
