package by.andd3dfx.numeric;

import java.util.Iterator;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/add-strings/">Task description</a>
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 *
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 * </pre>
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        var chars1 = num1.toCharArray();
        var i = chars1.length - 1;

        var chars2 = num2.toCharArray();
        var j = chars2.length - 1;

        var sb = new StringBuilder();
        var accumulator = 0;
        while (i >= 0 && j >= 0) {
            int n1 = chars1[i] - '0';
            int n2 = chars2[j] - '0';

            accumulator = calcAccumulator(n1 + n2 + accumulator, sb);

            i--;
            j--;
        }
        while (i >= 0) {
            int n1 = chars1[i] - '0';
            accumulator = calcAccumulator(n1 + accumulator, sb);
            i--;
        }
        while (j >= 0) {
            int n2 = chars2[j] - '0';
            accumulator = calcAccumulator(n2 + accumulator, sb);
            j--;
        }
        if (accumulator > 0) {
            sb.append(accumulator);
        }

        return sb.reverse().toString();
    }

    private static int calcAccumulator(int res, StringBuilder sb) {
        if (res <= 9) {
            sb.append(res);
        } else {
            sb.append(res % 10);
        }
        return res / 10;
    }

    public static String addStrings_usingIterators(String num1, String num2) {
        var iterator1 = new DigitsIterator(num1);
        var iterator2 = new DigitsIterator(num2);

        var sb = new StringBuilder();
        var accumulator = 0;
        while (iterator1.hasNext() || iterator2.hasNext() || accumulator > 0) {
            int n1 = iterator1.next();
            int n2 = iterator2.next();

            accumulator = calcAccumulator(n1 + n2 + accumulator, sb);
        }

        return sb.reverse().toString();
    }

    public static class DigitsIterator implements Iterator<Integer> {

        private final char[] chars;
        private int index;

        public DigitsIterator(String str) {
            this.chars = str.toCharArray();
            this.index = chars.length - 1;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            if (index >= 0) {
                return chars[index--] - '0';
            }
            return 0;
        }
    }
}
