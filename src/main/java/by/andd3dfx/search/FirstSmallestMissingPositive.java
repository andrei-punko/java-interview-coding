package by.andd3dfx.search;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/first-missing-positive/">Task description</a>
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * </pre>
 *
 * @see <a href="https://youtu.be/0i7x_YEXOpA">Video solution</a>
 */
public class FirstSmallestMissingPositive {

    /**
     * Good idea was that if we have n-length array,
     * the smallest missing positive integer will not be greater than n
     */
    public static int find(int[] nums) {
        int[] presence = new int[nums.length + 1];

        for (int num : nums) {
            if (num > 0 && num < presence.length) {
                presence[num] = 1;
            }
        }

        int position = 1;
        for (; position < presence.length; position++) {
            if (presence[position] == 0) {
                return position;
            }
        }
        return position;
    }
}
