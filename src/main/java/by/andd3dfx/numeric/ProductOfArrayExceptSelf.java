package by.andd3dfx.numeric;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">Task description</a>
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * </pre>
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        var n = nums.length;
        var left = new int[n];
        var right = new int[n];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        nums[0] = right[1];
        nums[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }
        return nums;
    }
}
