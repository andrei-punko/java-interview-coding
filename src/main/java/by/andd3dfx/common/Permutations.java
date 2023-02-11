package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        populate(result, 0, nums);
        return result;
    }

    private static void populate(List<List<Integer>> result, int start, int[] nums) {
        if (start == nums.length) {
            result.add(toList(nums));
            return;
        }

        for (int k = start; k < nums.length; k++) {
            swap(nums, start, k);
            populate(result, start + 1, nums);
            swap(nums, start, k);
        }
    }

    private static List<Integer> toList(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(value -> value)
                .collect(Collectors.toList());
    }

    private static void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
