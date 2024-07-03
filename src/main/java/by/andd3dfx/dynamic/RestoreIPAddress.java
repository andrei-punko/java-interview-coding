package by.andd3dfx.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/restore-ip-addresses/">Task description</a>
 *
 * A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245",
 * "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed
 * by inserting dots into s. You are not allowed to reorder or remove any digits in s.
 * You may return the valid IP addresses in any order.
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * </pre>
 *
 * @see <a href="https://youtu.be/bpSA5MJ36UQ">Video solution</a>
 */
public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        solve(s, result, "", 0);
        return result;
    }

    private void solve(String s, List<String> result, String tmp, int numbersAmount) {
        if (numbersAmount == 4 && s.isEmpty()) {
            result.add(tmp.substring(1));
            return;
        }
        if (s.isEmpty()) {
            return;
        }

        for (int i = 1; i <= Math.min(3, s.length()); i++) {
            String substring = s.substring(0, i);
            if (substring.matches("^0+\\d+")) {
                continue;
            }
            var number = Integer.valueOf(substring);
            if (number <= 255) {
                solve(s.substring(i), result, tmp + "." + number, numbersAmount + 1);
            }
        }
    }
}
