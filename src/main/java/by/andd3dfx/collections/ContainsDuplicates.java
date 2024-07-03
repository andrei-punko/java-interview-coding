package by.andd3dfx.collections;

import java.util.HashSet;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/contains-duplicate/">Task description</a>
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * </pre>
 */
public class ContainsDuplicates {

    public boolean usingSet(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean usingSortWithEarlyReturn(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[minIndex]) {
                    return true;
                }
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            swap(nums, i, minIndex);
        }
        return false;
    }

    private void swap(int[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
