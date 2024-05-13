package by.andd3dfx.common;

import java.util.Arrays;

/**
 * <pre>
 * Имеется коробка со сторонами: A × B × C.
 * Определить, пройдёт ли она в дверь с размерами M × K.
 * </pre>
 *
 * @see <a href="https://youtu.be/ix81AbCNiBE">Video solution</a>
 */
public class DoorNBox {

    public static boolean couldPass(int[] boxSize, int[] doorSize) {
        var box = Arrays.stream(boxSize).sorted().toArray();
        var door = Arrays.stream(doorSize).sorted().toArray();

        return box[0] <= door[0] && box[1] <= door[1];
    }
}
