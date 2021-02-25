package by.andd3dfx.interview.train2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Build string with ranges for defined list:
 * [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
 * [1,4,3,2] => "1-4"
 * [1,4] => "1,4"
 */
public class ArrayRanges {

    public class Range {
        int left;
        int right;
    }

    public String compact(int[] values) {
        if (values.length == 0) {
            return "";
        }

        Arrays.sort(values);

        List<Range> ranges = new ArrayList<>();
        Range tmpRange = new Range();
        tmpRange.left = values[0];
        tmpRange.right = values[0];

        for (int value : values) {
            if (value == tmpRange.right + 1) {
                tmpRange.right = value;
            } else {
                tmpRange = new Range();
                tmpRange.left = value;
                tmpRange.right = value;
                ranges.add(tmpRange);
            }
        }

        return ranges.stream()
                .map(range -> {
                    if (range.left == range.right) return String.valueOf(range.left);

                    return range.left + "-" + range.right;
                })
                .collect(Collectors.joining(","));
    }
}
