package by.andd3dfx.collections;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Task description</a>
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each
 * unique element appears only once. The relative order of the elements should be kept the same. Then return
 * the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were
 * present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4
 * respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * @see <a href="https://youtu.be/gbReaBoFHkc">Video solution</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        var left = 0;
        var right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[left] == nums[right]) {
                right++;
            }
            while (right < nums.length && nums[left] != nums[right]) {
                if (right - left > 1) {
                    nums[left + 1] = nums[right];
                }
                left++;
                right++;
            }
        }
        return left + 1;
    }
}
