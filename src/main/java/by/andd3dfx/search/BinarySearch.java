package by.andd3dfx.search;

/**
 * Implement binary search in a sorted array. Return element index or -1 if it doesn't exist
 */
public class BinarySearch {

    public static int perform(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int steps = 0;

        try {
            while (left <= right) {
                steps++;

                int middle = Math.floorDiv(left + right, 2);
                if (array[middle] < target) {
                    left = middle + 1;
                } else if (array[middle] > target) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            }

            return -1;
        } finally {
            System.out.println("Total steps count: " + steps);
        }
    }
}
