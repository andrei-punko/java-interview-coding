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

    public static List<Integer> determine(int[] nums, int i, int k) {
        if (k == 0) {
            return List.of();
        }
        var result = new ArrayList<Integer>();
        result.add(nums[i]);

        var curr = i;
        var left = i - 1;
        var right = i + 1;
        while (result.size() < k) {
            var leftD = (left < 0) ? Integer.MAX_VALUE : Math.abs(nums[left] - nums[curr]);
            var rightD = (right >= nums.length) ? Integer.MAX_VALUE : Math.abs(nums[right] - nums[curr]);
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
}
