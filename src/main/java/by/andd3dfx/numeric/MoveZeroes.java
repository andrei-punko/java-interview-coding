package by.andd3dfx.numeric;

import java.util.Arrays;

/**
 * <pre>
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 * </pre>
 *
 * @see <a href="https://youtu.be/IV5EIDRYZ9U">Video solution</a>
 */
public class MoveZeroes {

    public static void moveZeroes(int[] items) {
        int i = 0;
        for (var item : items) {
            if (item != 0) {
                items[i] = item;
                i++;
            }
        }

        Arrays.fill(items, i, items.length, 0);
    }
}
