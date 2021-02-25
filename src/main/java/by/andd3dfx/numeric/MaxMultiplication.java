package by.andd3dfx.numeric;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 * Write method which takes array and returns max product of 3 numbers taken from this array
 */
public class MaxMultiplication {

    public static long maxMultiplication(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(toList());
        int size = list.size();
        long max1 = list.get(size - 1) * list.get(size - 2) * list.get(size - 3);
        long max2 = list.get(0) * list.get(1) * list.get(size - 1);
        return max1 > max2 ? max1 : max2;
    }
}
