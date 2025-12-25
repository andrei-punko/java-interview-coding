package by.andd3dfx.common;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Build string with ranges for (unsorted) list of natural numbers:
 * [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
 * [1,4,3,2] => "1-4"
 * [1,4] => "1,4"
 * </pre>
 *
 * @see <a href="https://youtu.be/ql6TROfbnYk">Video solution</a>
 */
public class ArrayRanges {

    @AllArgsConstructor
    public static class Range {
        private int left;
        private int right;

        @Override
        public String toString() {
            if (left == right) {
                return String.valueOf(left);
            }
            return left + "-" + right;
        }
    }

    public String compact(int[] values) {
        if (values.length == 0) {
            return "";
        }

        Arrays.sort(values);

        List<Range> ranges = new ArrayList<>();
        Range draftRange = new Range(values[0], values[0]);
        ranges.add(draftRange);

        for (var value : values) {
            if ((value - draftRange.right) <= 1) {
                draftRange.right = value;
                continue;
            }

            draftRange = new Range(value, value);
            ranges.add(draftRange);
        }

        return ranges.stream()
            .map(Range::toString)
            .collect(Collectors.joining(","));
    }
}
