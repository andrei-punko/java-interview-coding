package by.andd3dfx.numeric;

import java.util.List;

/**
 * <pre>
 * Implement the findMaxSum() method that returns the largest sum of any two elements
 * in the given list of positive numbers.
 *
 * For example, the largest sum of the list {5, 9, 7, 11} is the sum of the elements 9 and 11, which is 20.
 * </pre>
 */
public class MaxSum {

    public static int findMaxSum(List<Integer> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List size should be at least 2!");
        }

        var m1 = Math.max(list.get(0), list.get(1));
        var m2 = Math.min(list.get(0), list.get(1));

        for (int i = 2; i < list.size(); i++) {
            var item = list.get(i);
            if (item > m1 || item > m2) {
                if (item > m1) {
                    m2 = m1;
                    m1 = item;
                } else {
                    m2 = item;
                }
            }
        }
        return m1 + m2;
    }
}
