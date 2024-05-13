package by.andd3dfx.search;

/**
 * Implement interpolation search in a sorted array. Return element index or -1 if it doesn't exist
 *
 * @see <a href="https://youtu.be/kRTntkCB_a4">Video solution</a>
 */
public class InterpolationSearch {

    public static int perform(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        int steps = 0;

        try {
            while (min <= max) {
                steps++;

                int mid = determineMid(array, target, min, max);
                if (mid < min) {
                    mid = min;
                }
                if (mid > max) {
                    mid = max;
                }

                if (array[mid] == target) {
                    return mid;
                }
                if (array[mid] < target) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            return -1;
        } finally {
            System.out.println("target: " + target + ", total steps count: " + steps);
        }
    }

    static int determineMid(int[] array, int target, int min, int max) {
        if (array[max] == array[min]) {
            return min;
        }
        return min + (max - min) * (target - array[min]) / (array[max] - array[min]);
    }
}
