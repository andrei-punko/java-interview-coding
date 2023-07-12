package by.andd3dfx.numeric;

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

    public static int find(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result ^= numbers[i];   // use fact that: ((X xor Y) xor Y) == X
        }
        return result;
    }
}
