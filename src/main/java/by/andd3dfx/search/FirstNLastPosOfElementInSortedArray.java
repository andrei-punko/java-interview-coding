package by.andd3dfx.search;

/**
 * <pre>
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * </pre>
 *
 * @see <a href="https://youtu.be/6s-kAtOFXuY">Video solution</a>
 */
public class FirstNLastPosOfElementInSortedArray {

    public static int[] searchRange(int[] items, int target) {
        var result = binarySearch(items, target);

        var left = result;
        while (left > 0) {
            if (items[left - 1] != target) {
                break;
            }
            left--;
        }

        var right = result;
        while (right < items.length - 1) {
            if (items[right + 1] != target) {
                break;
            }
            right++;
        }

        return new int[]{left, right};
    }

    private static int binarySearch(int[] items, int target) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int middle = Math.floorDiv(left + right, 2);
            if (items[middle] < target) {
                left = middle + 1;
            } else if (items[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
