package by.andd3dfx.sorting;

import java.util.Random;

/**
 * Mix an array
 *
 * @see <a href="https://youtu.be/Ru9UA_74t30">Video solution</a>
 */
public class ArrayMixer {

    private static final Random random = new Random();

    /**
     * <pre>
     * Use Fisher–Yates algorithm from <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">article</a>
     * </pre>
     */
    public static <T> void shuffle(T[] array) {
        var n = array.length;
        for (var i = n - 1; i >= 1; i--) {
            var j = random.nextInt(i + 1);
            swap(array, i, j);
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
