package by.andd3dfx.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/two-sum/">Task description</a>
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Try to solve task using algorithm with O(n) complexity.
 * </pre>
 *
 * @see <a href="https://youtu.be/CrQdpjsr26w">Video solution</a>
 */
public class FindSumOfTwoInArray {

    public static int[] find_On2(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] find_On(int[] arr, int sum) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            var item = arr[i];
            if (valueToIndexMap.containsKey(sum - item)) {
                return new int[]{i, valueToIndexMap.get(sum - item)};
            }
            valueToIndexMap.put(item, i);
        }
        return null;
    }
}
