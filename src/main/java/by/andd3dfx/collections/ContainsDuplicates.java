package by.andd3dfx.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * https://leetcode.com/problems/contains-duplicate/
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
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean usingSortWithEarlyReturn(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min_index = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[min_index]) {
                    return true;
                }
                if (nums[j] < nums[min_index]) {
                    min_index = j;
                }
            }

            swap(nums, i, min_index);
        }
        return false;
    }

    private void swap(int[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
