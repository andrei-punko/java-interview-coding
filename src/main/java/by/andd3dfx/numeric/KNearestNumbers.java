package by.andd3dfx.numeric;

import java.util.ArrayList;
import java.util.List;

/**
 * Find K nearest numbers for item placed on i-th position in array of numbers.
 * Item nums[i] should be included into result.
 * <p>
 * Examples:
 * a = [1 2 2 3 _4_ 4 4 5 6]
 * i=4, k=2, result=[4 4]
 * <p>
 * a = [1 2 3 _4_ 5 6]
 * i=3, k=2, result=[4 3] or [4 5]
 * <p>
 * a = [_1_ 2 3 4 5 6]
 * i=0, k=3, result=[1 2 3]
 * <p>
 * a = [1 2 2 3 _3_ 56 78 79 79 100]
 * i=4, k=3, result=[3 3 2]
 */
public class KNearestNumbers {

    public static List<Integer> find(int[] nums, int i, int k) {
        if (i < 0 || i >= nums.length) {
            throw new IllegalArgumentException("Index `i` is out of array's range!");
        }
        if (k < 0) {
            throw new IllegalArgumentException("Requested amount of items `k` is negative!");
        }

        if (k == 0) {
            return List.of();
        }
        var result = new ArrayList<Integer>();
        result.add(nums[i]);

        var left = i - 1;
        var right = i + 1;
        while (result.size() < k) {
            var leftD = determineLeftD(nums, left, i);
            var rightD = determineRightD(nums, right, i);

            if (leftD < rightD) {
                result.add(nums[left]);
                left--;
            } else {
                result.add(nums[right]);
                right++;
            }

        }
        return result;
    }

    private static int determineLeftD(int[] nums, int left, int curr) {
        if (left < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.abs(nums[left] - nums[curr]);
    }

    private static int determineRightD(int[] nums, int right, int curr) {
        if (right >= nums.length) {
            return Integer.MAX_VALUE;
        }
        return Math.abs(nums[right] - nums[curr]);
    }
}
