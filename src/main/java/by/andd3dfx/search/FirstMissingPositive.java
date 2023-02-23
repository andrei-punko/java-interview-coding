package by.andd3dfx.search;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p>
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

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
