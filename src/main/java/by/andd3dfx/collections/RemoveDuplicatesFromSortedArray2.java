package by.andd3dfx.collections;

/**
 * <pre>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
 * element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
 * k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
 * extra memory.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3
 * respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3
 * respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 */
public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        var left = 0;
        var right = 1;
        var counter = 1;

        while (right < nums.length) {
            while (right < nums.length && nums[left] == nums[right]) {
                if (counter < 2) {
                    counter++;
                }
                right++;
            }

            while (right < nums.length && nums[left] != nums[right]) {
                if (right - left > 1) {
                    nums[left + counter] = nums[right];
                }
                left++;
                right++;
            }
        }
        return left + counter;
    }
}
