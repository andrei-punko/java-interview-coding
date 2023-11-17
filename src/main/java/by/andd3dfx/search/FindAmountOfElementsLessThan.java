package by.andd3dfx.search;

/**
 * <pre>
 * Implement function countNumbers() that accepts a sorted array of integers and counts the number of array elements
 * that are less than the parameter lessThan.
 *
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array
 * elements less than 4.
 * </pre>
 */
public class FindAmountOfElementsLessThan {

    public static int usingPrimitiveIteration(int[] items, int lessThan) {
        var i = 0;
        while (i < items.length && items[i] < lessThan) {
            i++;
        }
        return i;
    }

    public static int usingBinarySearch(int[] items, int lessThan) {
        int left = 0;
        int right = items.length - 1;

        if (lessThan < items[left]) {
            return 0;
        }
        if (items[right] < lessThan) {
            return items.length;
        }

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (items[mid] < lessThan) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static int usingInterpolationSearch(int[] items, int lessThan) {
        int left = 0;
        int right = items.length - 1;

        while (right - left > 1) {
            int mid = determineMid(items, lessThan, left, right);
            if (mid < left) {
                mid = left;
            }
            if (mid > right) {
                mid = right;
            }

            if (items[mid] == lessThan) {
                return mid;
            }
            if (items[mid] < lessThan) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static int determineMid(int[] items, int target, int left, int right) {
        if (items[right] == items[left]) {
            return left;
        }
        return left + (right - left) * (target - items[left]) / (items[right] - items[left]);
    }
}
