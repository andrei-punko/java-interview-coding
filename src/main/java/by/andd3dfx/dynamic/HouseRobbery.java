package by.andd3dfx.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
 * connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
 * can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
 * </pre>
 */
public class HouseRobbery {

    public static int find(int[] nums) {
        Map<Integer, Integer> cache = new HashMap();
        return find(nums, cache, 0);
    }

    private static int find(int[] nums, Map<Integer, Integer> cache, int start) {
        if (cache.containsKey(start)) {
            return cache.get(start);
        }

        if (start > nums.length - 1) {
            cache.put(start, 0);
            return 0;
        }
        var value1 = nums[start] + find(nums, cache, start + 2);

        if (start > nums.length - 2) {
            cache.put(start, value1);
            return value1;
        }
        var value2 = nums[start + 1] + find(nums, cache, start + 3);

        int result = Math.max(value1, value2);
        cache.put(start, result);
        return result;
    }
}
