package by.andd3dfx.sorting.others;

import java.util.Random;

/**
 * Mix array
 */
public class ArrayMixer {

    private static final Random random = new Random();

    public static <T> void apply(T[] array) {
        for (int iteration = 0; iteration <= array.length; iteration++) {
            var i = random.nextInt(array.length);
            var j = random.nextInt(array.length);
            swap(array, i, j);
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
