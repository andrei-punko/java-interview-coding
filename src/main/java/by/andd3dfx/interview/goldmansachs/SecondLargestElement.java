package by.andd3dfx.interview.goldmansachs;

import java.util.Arrays;

/**
 * Find the second minimum in array of numbers
 */
public class SecondLargestElement {

    public static int find1(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Wrong array size: should have at least 2 items");
        }
        Arrays.sort(array);
        return array[array.length - 2];
    }

    public static int find2(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Wrong array size: should have at least 2 items");
        }
        int max_1 = max(array[0], array[1]);
        int max_2 = min(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            if (array[i] >= max_1) {
                max_2 = max_1;
                max_1 = array[i];
                continue;
            }
            if (array[i] >= max_2) {
                max_2 = array[i];
                continue;
            }
        }
        return max_2;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
