package by.andd3dfx.numeric;

import java.util.Arrays;

import static java.lang.Math.max;

/**
 * Write method which takes array and returns max product of 3 numbers taken from this array
 *
 * @see <a href="https://youtu.be/wzO6abwg4y4">Video solution</a>
 */
public class MaxMultiplicationOf3InArray {

    public static long find(int[] arr) {
        if (arr.length < 3) {
            throw new IllegalArgumentException("Input array should contain at least 3 elements!");
        }

        var list = Arrays.stream(arr).boxed().sorted().toList();
        int size = list.size();
        var max1 = list.get(size - 3) * list.get(size - 2) * list.get(size - 1);
        var max2 = list.get(0) * list.get(size - 2) * list.get(size - 1);
        var max3 = list.get(0) * list.get(1) * list.get(size - 1);
        var max4 = list.get(0) * list.get(1) * list.get(2);

        return max(max1, max(max2, max(max3, max4)));
    }
}
