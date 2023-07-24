package by.andd3dfx.numeric;

import java.util.HashSet;

/**
 * <pre>
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * </pre>
 */
public class FindNumberWhichAppearsOnce {

    public static int findSubOptimal(int[] numbers) {
        var set = new HashSet<Integer>();
        for (var number : numbers) {
            if (!set.add(number)) {
                set.remove(number);
            }
        }

        return set.toArray(new Integer[0])[0];
    }

    public static int find(int[] numbers) {
        int result = 0;
        for (var number : numbers) {
            result ^= number;   // use fact that: ((X xor Y) xor Y) == X
        }
        return result;
    }
}
