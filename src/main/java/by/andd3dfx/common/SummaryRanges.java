package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/summary-ranges/description/">Task description</a>
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums
 * is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *     "a->b" if a != b
 *     "a" if a == b
 *
 * Example 1:
 *   Input: nums = [0,1,2,4,5,7]
 *   Output: ["0->2","4->5","7"]
 *   Explanation: The ranges are:
 *   [0,2] --> "0->2"
 *   [4,5] --> "4->5"
 *   [7,7] --> "7"
 *
 * Example 2:
 *   Input: nums = [0,2,3,4,6,8,9]
 *   Output: ["0","2->4","6","8->9"]
 *   Explanation: The ranges are:
 *   [0,0] --> "0"
 *   [2,4] --> "2->4"
 *   [6,6] --> "6"
 *   [8,9] --> "8->9"
 * </pre>
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }

        List<Range> ranges = new ArrayList<>();
        Range draftRange = new Range(nums[0], nums[0]);
        ranges.add(draftRange);

        for (var value : nums) {
            if ((value - draftRange.right) <= 1) {
                draftRange.right = value;
                continue;
            }

            draftRange = new Range(value, value);
            ranges.add(draftRange);
        }

        return ranges.stream()
            .map(Range::toString)
            .toList();
    }

    @AllArgsConstructor
    public static class Range {

        private int left;
        private int right;

        @Override
        public String toString() {
            if (left == right) {
                return String.valueOf(left);
            }
            return left + "->" + right;
        }
    }
}
