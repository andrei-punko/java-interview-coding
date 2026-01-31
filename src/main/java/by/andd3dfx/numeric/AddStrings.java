package by.andd3dfx.numeric;

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

            var res = n1 + n2 + accumulator;
            accumulator = 0;
            if (res <= 9) {
                sb.append(res);
            } else {
                sb.append(res % 10);
                res = res / 10;
                accumulator = res;
            }

            i--;
            j--;
        }
        while (i >= 0) {
            int n1 = chars1[i] - '0' + accumulator;
            accumulator = 0;
            sb.append(n1);
            i--;
        }
        while (j >= 0) {
            int n2 = chars2[j] - '0' + accumulator;
            accumulator = 0;
            sb.append(n2);
            j--;
        }

        return sb.reverse().toString();
    }
}
